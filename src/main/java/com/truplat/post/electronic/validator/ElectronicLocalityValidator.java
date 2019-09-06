package com.truplat.post.electronic.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truplat.common.CommonService;
import com.truplat.common.data.City;
import com.truplat.post.electronic.ElectronicRequest;

@Component
public class ElectronicLocalityValidator implements ConstraintValidator<ElectronicLocalityValid, ElectronicRequest> {

	@Autowired
	private CommonService commonService;

	@Override
	public boolean isValid(ElectronicRequest request, ConstraintValidatorContext constraintValidatorContext) {
		
		City city = commonService.getCities().stream().filter(c -> c.getName().equals(request.getCity())).findFirst().orElse(null);
		if (city != null) {
			return city.getLocalities().stream().filter(l -> l.getName().equals(request.getLocality())).count() > 0;
		}
		return false;
	}
}
