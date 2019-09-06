package com.truplat.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class AmountValidator implements ConstraintValidator<AmountValid, String> {
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		try{
			int amount = Integer.parseInt(value);
			if(amount < 1 || amount > 99999999){
				constraintValidatorContext.buildConstraintViolationWithTemplate("Amount should be in between 1 and 99999999").addConstraintViolation().disableDefaultConstraintViolation();
				return false;
			}
		} catch (Exception e) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Amount is invalid").addConstraintViolation().disableDefaultConstraintViolation();
			return false;
		}
		return true;
	}
	
}
