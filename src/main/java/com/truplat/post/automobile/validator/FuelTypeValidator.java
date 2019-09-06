package com.truplat.post.automobile.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.truplat.post.automobile.FuelType;

@Component
public class FuelTypeValidator implements ConstraintValidator<FuelTypeValid, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = FuelType.getLabel(value) != null;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Fuel Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
}
