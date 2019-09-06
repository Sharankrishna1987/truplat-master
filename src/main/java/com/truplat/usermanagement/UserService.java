package com.truplat.usermanagement;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.truplat.common.exception.UserException;
import com.truplat.common.mail.EmailService;
import com.truplat.common.mail.Mail;

@Service
public class UserService {
	
	private static final String USER_DOES_NOT_EXIST = "User does not exist.";

	@Autowired
	UserRepository userRepository;
	
    @Autowired
    private EmailService emailService;
    
	@Autowired
	UserCredentialRepository userCredentialRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${application.url}")
	private String applicationURL;
	
	@Transactional
	public void addUser(User user, String password) {
		if(isOfficialEmailAddressInUse(user.getOfficialEmailAddress())){
			throw new UserException("The official email address provided is aleady in use.");
		}
		if(isPersonalEmailAddressInUse(user.getPersonalEmailAddress())){
			throw new UserException("The personal email address provided is aleady in use.");
		}
		user = userRepository.save(user);
		String activationCode = UUID.randomUUID().toString();
		userCredentialRepository.save(new UserCredential(user.getUserId(), passwordEncoder.encode(password), false, activationCode));
		
        Mail mail = new Mail();
        mail.setTo(user.getOfficialEmailAddress());
        mail.setSubject("Truplat Account Activation");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", (user.getFirstName() + " " + user.getLastName()).trim());
        model.put("url", applicationURL + "user/activate/" + user.getUserId() + "/" + activationCode);
        mail.setModel(model);

        emailService.sendSimpleMessage(mail, "welcome");
	}
	
	@Transactional
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
	
	public User getUserByPersonalEmailAddress(String personalEmailAddress) {
		return userRepository.findByPersonalEmailAddressAndActive(personalEmailAddress, true);
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	private boolean isOfficialEmailAddressInUse(String officialEmailAddress){
		return userRepository.findByOfficialEmailAddress(officialEmailAddress) != null;
	}
	
	private boolean isPersonalEmailAddressInUse(String personalEmailAddress){
		return userRepository.findByPersonalEmailAddressAndActive(personalEmailAddress, true) != null;
	}
	
	@Transactional
	public boolean activateUser(Integer userId, String activationCode){
		UserCredential userCredential = userCredentialRepository.findById(userId).orElseThrow(() -> new UserException(USER_DOES_NOT_EXIST));
		return activateUserCredential(activationCode, userCredential);
	}

	public void forgotPassword(String personalEmailAddress, String dob){

		User user = userRepository.findByPersonalEmailAddressAndActive(personalEmailAddress, true);
		
		if(user == null){
			throw new UserException(USER_DOES_NOT_EXIST);
		}
		
		Date date;
		try {
			date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(dob).getTime());
		} catch (ParseException e) {
			throw new UserException("Date of Birth format is incorrect.");
		}
		if(user.getPersonalEmailAddress().equals(personalEmailAddress) && user.getDob().toLocalDate().compareTo(date.toLocalDate()) == 0){
			UserCredential userCredential = userCredentialRepository.findById(user.getUserId()).orElseThrow(() -> new UserException(USER_DOES_NOT_EXIST));
			String activationCode = UUID.randomUUID().toString();
			userCredential.setActive(false);
			userCredential.setActivationCode(activationCode);	
			userCredential.setActivationTime(new Date(new java.util.Date().getTime()));
			userCredential.setRetry(0);
			userCredentialRepository.save(userCredential);
			
	        Mail mail = new Mail();
	        mail.setTo(user.getPersonalEmailAddress());
	         mail.setSubject("Truplat Reset Password");

	         Map<String, Object> model = new HashMap<String, Object>();
	         model.put("name", (user.getFirstName() + " " + user.getLastName()).trim());
	         model.put("url", applicationURL + "registration/reset/" + user.getUserId() + "/" + activationCode);
	         mail.setModel(model);

	         emailService.sendSimpleMessage(mail, "forgotPassword");
		}
	}
	
	@Transactional
	public void resetPassword(Integer userId, String password, String activationCode){

		UserCredential userCredential = userCredentialRepository.findById(userId).orElseThrow(() -> new UserException(USER_DOES_NOT_EXIST));
		userCredential.setPassWord(passwordEncoder.encode(password));
		activateUserCredential(activationCode, userCredential);

	}
	
	@Transactional
	public void changePassword(Integer userId, String oldPassword, String newPassword){

		UserCredential userCredential = userCredentialRepository.findById(userId).orElseThrow(() -> new UserException(USER_DOES_NOT_EXIST));
		if(oldPassword != null && oldPassword.equals(userCredential.getPassWord())){
			userCredential.setPassWord(newPassword);
			userCredential.setRetry(0);
		} else {
			userCredential.setRetry(userCredential.getRetry() + 1);
		}
		userCredentialRepository.save(userCredential);
	}
	
	private void checkForRetryLimit(int retry){
		if(retry > 4){
			throw new UserException("Retry limit has been exceeded.");
		}
	}
	
	private boolean activateUserCredential(String activationCode, UserCredential userCredential) {
		checkForRetryLimit(userCredential.getRetry());
		if(userCredential.getActivationCode() == null || activationCode == null) {
			throw new UserException("User cannot be activated.");
		}
		boolean activated = false;
		if(userCredential.getActivationCode().equals(activationCode)){
			userCredential.setActive(true);
			userCredential.setActivationCode(null);	
			userCredential.setActivationTime(null);
			userCredential.setRetry(0);
			activated = true;
		} else{
			userCredential.setRetry(userCredential.getRetry() + 1);
		}		
		userCredentialRepository.save(userCredential);
		if(activated){
			User user = userRepository.findById(userCredential.getUserId()).orElseThrow(() -> new UserException(USER_DOES_NOT_EXIST));
			user.setActive(true);
			userRepository.save(user);
		}
		return activated;
	}


}
