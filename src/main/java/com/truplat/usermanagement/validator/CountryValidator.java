package com.truplat.usermanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truplat.common.CommonService;
import com.truplat.usermanagement.UserRequest;

@Component
public class CountryValidator implements ConstraintValidator<CountryValid, UserRequest> {

	@Autowired
	private CommonService commonService;
	
    @Override
    public boolean isValid(UserRequest userRequest, ConstraintValidatorContext constraintValidatorContext) {
//    	return commonService.getCountries().stream()
//    			  .filter(c -> c.getName().equals(userRequest.getCountry())).count() > 0;
    	return true;
    }
}
