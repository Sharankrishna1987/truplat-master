package com.truplat.post.realestate.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class PropertyTypeValidator implements ConstraintValidator<PropertyTypeValid, String> {
	
	private List<String> propertyTypes = Arrays.asList("apartment", "house");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = propertyTypes.stream().filter(v -> v.equals(value)).count() > 0;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Property Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
	
}
