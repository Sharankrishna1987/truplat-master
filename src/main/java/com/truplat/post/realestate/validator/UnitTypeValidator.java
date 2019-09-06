package com.truplat.post.realestate.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class UnitTypeValidator implements ConstraintValidator<UnitTypeValid, String> {
	
	private List<String> unitTypes = Arrays.asList("1", "2", "3", "4");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = unitTypes.stream().filter(v -> v.equals(value)).count() > 0;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Unit Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
	
}
