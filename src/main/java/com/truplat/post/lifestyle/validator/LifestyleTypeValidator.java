package com.truplat.post.lifestyle.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.truplat.post.lifestyle.LifestyleType;

@Component
public class LifestyleTypeValidator implements ConstraintValidator<LifestyleTypeValid, String> {


	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = LifestyleType.getName(value) != null;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Lifestyle Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
}
