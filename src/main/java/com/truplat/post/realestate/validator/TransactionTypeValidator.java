package com.truplat.post.realestate.validator;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class TransactionTypeValidator implements ConstraintValidator<TransactionTypeValid, String> {
	
	private List<String> transactionTypes = Arrays.asList("sell", "rent");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean isValid = transactionTypes.stream().filter(v -> v.equals(value)).count() > 0;
		if(isValid == false) {
			constraintValidatorContext.buildConstraintViolationWithTemplate("Transaction Type is invalid").addConstraintViolation().disableDefaultConstraintViolation();
		}
		return isValid;
	}
	
}
