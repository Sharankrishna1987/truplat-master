package com.truplat.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truplat.common.CommonService;

@Component
public class CityValidator implements ConstraintValidator<CityValid, String> {

	@Autowired
	private CommonService commonService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = commonService.getCities().stream().filter(c -> c.getName().equals(value)).count() > 0;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("City is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
}
