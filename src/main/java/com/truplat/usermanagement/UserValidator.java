package com.truplat.usermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.truplat.common.CommonService;
import com.truplat.common.data.Organization;

@Component("beforeCreateUserValidator")
public class UserValidator implements Validator {

	@Autowired
	private CommonService commonService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UserRequest userRequest = (UserRequest) obj;
		Organization organization = commonService.getOrganizations().stream()
				.filter(o -> o.getId().equals(userRequest.getOrganization().getId())).findFirst().orElse(null);
		if (organization == null || userRequest.getOfficialEmailAddress().toLowerCase()
				.endsWith(organization.getEmailDomain().toLowerCase())) {
			errors.rejectValue("email.error", "Official email domain is invalid");
		}

	}

}