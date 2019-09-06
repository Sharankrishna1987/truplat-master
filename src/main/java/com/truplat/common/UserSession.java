package com.truplat.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.truplat.usermanagement.User;
import com.truplat.usermanagement.UserService;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	@Autowired
	private UserService userService;
	private User user = null;
	
	@Value("${default.user}")
	private String defaultUser;

    public User getCurrentUser() {
        if (user == null) {        	
        	String name = StringUtils.hasText(defaultUser) ? defaultUser : SecurityContextHolder.getContext().getAuthentication().getName();
        	user = userService.getUserByPersonalEmailAddress(name);
        }
        return user;
    }
}
