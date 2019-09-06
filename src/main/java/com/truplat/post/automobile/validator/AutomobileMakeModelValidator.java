package com.truplat.post.automobile.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.truplat.common.CommonService;
import com.truplat.post.automobile.AutomobileRequest;
import com.truplat.post.automobile.BikeMake;
import com.truplat.post.automobile.CarMake;
import com.truplat.post.automobile.VehicleType;

@Component
public class AutomobileMakeModelValidator implements ConstraintValidator<AutomobileMakeModelValid, AutomobileRequest> {

	@Autowired
	private CommonService commonService;

	@Override
	public boolean isValid(AutomobileRequest request, ConstraintValidatorContext constraintValidatorContext) {
		
		if(request.getVehicleType().equals(VehicleType.CAR.getValue())) {
			CarMake carMake = commonService.getCars().stream().filter(c -> c.getMake().equals(request.getMake())).findFirst().orElse(null);
			if (carMake != null) {
				return carMake.getCarModels().stream().filter(m -> m.getModel().equals(request.getModel())).count() > 0;
			}			
		} else if(request.getVehicleType().equals(VehicleType.BIKE.getValue())) {
			BikeMake bikeMake = commonService.getBikes().stream().filter(c -> c.getMake().equals(request.getMake())).findFirst().orElse(null);
			if (bikeMake != null) {
				return bikeMake.getBikeModels().stream().filter(m -> m.getModel().equals(request.getModel())).count() > 0;
			}			
		}
		return false;
	}
}
