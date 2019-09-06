package com.truplat.post.electronic.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.truplat.post.electronic.ElectronicType;

@Component
public class ElectronicTypeValidator implements ConstraintValidator<ElectronicTypeValid, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = ElectronicType.getName(value) != null;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Electronic Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
}
