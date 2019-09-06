package com.truplat.usermanagement.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truplat.common.CommonService;
import com.truplat.usermanagement.UserRequest;

@Component
public class StateValidator implements ConstraintValidator<StateValid, UserRequest> {

	@Autowired
	private CommonService commonService;

	@Override
	public boolean isValid(UserRequest userRequest, ConstraintValidatorContext constraintValidatorContext) {
//		Country country = commonService.getCountries().stream()
//				.filter(c -> c.getName().equals(userRequest.getCountry())).findAny().orElse(null);
//		if (country != null) {
//			return country.getStates().stream().filter(s -> s.getName().equals(userRequest.getState())).count() > 0;
//		}

		return false;
	}
}
