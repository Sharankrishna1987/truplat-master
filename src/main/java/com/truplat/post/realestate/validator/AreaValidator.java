package com.truplat.post.realestate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class AreaValidator implements ConstraintValidator<AreaValid, String> {
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		try{
			int area = Integer.parseInt(value);
			if(area < 1 || area > 999999){
				constraintValidatorContext.buildConstraintViolationWithTemplate("Area should be in between 1 and 999999").addConstraintViolation().disableDefaultConstraintViolation();
				return false;
			}
		} catch (Exception e) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Area is invalid").addConstraintViolation().disableDefaultConstraintViolation();
			return false;
		}
		return true;
	}
	
}
