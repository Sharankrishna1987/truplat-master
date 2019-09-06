package com.truplat.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.truplat.usermanagement.UserCredential;

public class TruplatUserPrincipal implements UserDetails {


	private static final long serialVersionUID = -6738332099743576211L;
	
	private UserCredential userCredential;

	public TruplatUserPrincipal(UserCredential userCredential) {
		this.userCredential = userCredential;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return userCredential.getPassWord();
	}

	@Override
	public String getUsername() {
		return userCredential.getPersonalEmailAddress();
	}

	@Override
	public boolean isAccountNonExpired() {
		return userCredential.isActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		return userCredential.isActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return userCredential.isActive();
	}

	@Override
	public boolean isEnabled() {
		return userCredential.isActive();
	}

}
