package com.truplat.post.automobile.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.truplat.post.automobile.VehicleType;

@Component
public class VehicleTypeValidator implements ConstraintValidator<VehicleTypeValid, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = VehicleType.getLabel(value) != null;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Vehicle Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
}
