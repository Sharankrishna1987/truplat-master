package com.truplat.usermanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truplat.common.CommonService;
import com.truplat.common.data.Organization;
import com.truplat.usermanagement.UserRequest;

@Component
public class OrganizationEmailDomainValidator implements ConstraintValidator<OrganizationEmailDomainValid, UserRequest> {

	@Autowired
	private CommonService commonService;
	
    @Override
    public boolean isValid(UserRequest userRequest, ConstraintValidatorContext constraintValidatorContext) {
    	
    	if(userRequest.getOfficialEmailAddress() == null || userRequest.getOrganization() == null) {
    		return false;
    	}
    	
    	Organization organization = commonService.getOrganizations().stream().filter(o -> o.getId().equals(userRequest.getOrganization().getId())).findFirst().orElse(null);
    	if(organization != null && userRequest.getOfficialEmailAddress().toLowerCase().endsWith(organization.getEmailDomain().toLowerCase())){
    		return true;
    	}
    	return false;
    }
}
