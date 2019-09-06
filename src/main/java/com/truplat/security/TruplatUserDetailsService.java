package com.truplat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.truplat.common.exception.UserException;
import com.truplat.usermanagement.User;
import com.truplat.usermanagement.UserCredential;
import com.truplat.usermanagement.UserCredentialRepository;
import com.truplat.usermanagement.UserRepository;

public class TruplatUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserCredentialRepository userCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try{
			User user = userRepository.findByPersonalEmailAddressAndActive(username, true);
			UserCredential userCredential = userCredentialRepository.findById(user.getUserId()).orElseThrow(() -> new UserException("User does not exist."));
			userCredential.setPersonalEmailAddress(username);
			return new TruplatUserPrincipal(userCredential);
		} catch(Exception e) {
			throw new UsernameNotFoundException(username);
		}		
	}

}
