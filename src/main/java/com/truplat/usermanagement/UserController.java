package com.truplat.usermanagement;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.truplat.common.UserSession;

@RestController
public class UserController {
	
	@Autowired
	private UserSession userSession;

	@Autowired
	UserService userService;
	
	@Value("${application.url}")
	private String applicationURL;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/add")
	public ResponseEntity<String> addUser(@RequestBody @Valid UserRequest userRequest) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		User user = modelMapper.map(userRequest, User.class);
		user.setActive(false);
		user.setModifiedBy("admin");
		userService.addUser(user, userRequest.getPassword());
		return ResponseEntity.ok("success");
	}


	@RequestMapping(method = RequestMethod.POST, value = "/authenticalted/updateuser")
	public ResponseEntity<String> updateUser(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
		
		User user = userSession.getCurrentUser();
		user.setPersonalEmailAddress(updateUserRequest.getPersonalEmailAddress());
		user.setFirstName(updateUserRequest.getFirstName());
		user.setLastName(updateUserRequest.getLastName());
		user.setGender(updateUserRequest.getGender());		
		user.setDob(Date.valueOf(updateUserRequest.getDob()));
		user.setCity(updateUserRequest.getCity());
		user.setPincode(updateUserRequest.getPincode());
		user.setContactNumber(updateUserRequest.getContactNumber());
		if("yes".equals(user.getRestrictedAccess())){
			user.setRestrictedAccess(updateUserRequest.getRestrictedAccess());
		}
		userService.updateUser(user);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/authenticated/get")
	public UserResponse getUser() {
		
		ModelMapper modelMapper = new ModelMapper();		
		return modelMapper.map(userSession.getCurrentUser(), UserResponse.class);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/activate/{userId}/{activationCode}")
	public void activateUser(@PathVariable Integer userId, @PathVariable String activationCode, HttpServletResponse response) throws IOException {
		if(userService.activateUser(userId, activationCode)){
			response.sendRedirect(applicationURL + "registration/activationsuccessful");
		} else {
			response.sendRedirect(applicationURL + "registration/activationfailed");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/forgotpassword")
	public ResponseEntity<String> forgotPassword(@RequestBody UserRequest userRequest){
		userService.forgotPassword(userRequest.getPersonalEmailAddress(), userRequest.getDob());
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/resetpassword")
	public ResponseEntity<String> resetPassword(@RequestBody UserRequest userRequest){
		userService.resetPassword(Integer.valueOf(userRequest.getUserId()), userRequest.getPassword(), userRequest.getActivationCode());
		return ResponseEntity.ok("success");
	}
	
	
//	private ModelMapper getUserModelMapper() {
//		ModelMapper modelMapper = new ModelMapper();
//	    Provider<Date> dateProvider = new AbstractProvider<Date>() {
//	        @Override
//	        public Date get() {
//	            return new Date(System.currentTimeMillis());
//	        }
//	    };
//
//	    Converter<String, Date> toStringDate = new AbstractConverter<String, Date>() {
//	        @Override
//	        protected Date convert(String source) {
//	            SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
//	            try {
//					return new Date(format.parse(source).getTime());
//				} catch (ParseException e) {					
//					e.printStackTrace();
//					throw new RuntimeException(e);
//				}
//	        }
//	    };
//	    modelMapper.createTypeMap(String.class, Date.class);
//	    modelMapper.addConverter(toStringDate);
//	    modelMapper.getTypeMap(String.class, Date.class).setProvider(dateProvider);
//		return modelMapper;
//	}
	

}
