package com.truplat.common;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truplat.common.data.City;
import com.truplat.common.data.CityResponse;
import com.truplat.common.data.Locality;
import com.truplat.common.data.Organization;
import com.truplat.common.data.OrganizationResponse;
import com.truplat.common.data.VehicleResponse;
import com.truplat.post.automobile.BikeMake;
import com.truplat.post.automobile.BikeModel;
import com.truplat.post.automobile.CarMake;
import com.truplat.post.automobile.CarModel;

@RestController
public class CommonController {

	@Autowired
	CommonService commonService;

	@RequestMapping("/common/organizations")
	public List<OrganizationResponse> getOrganizations() {
		ModelMapper modelMapper = new ModelMapper();
		List<OrganizationResponse> organizationResponses = new ArrayList<>();
		for(Organization organization : commonService.getOrganizations()) {
			organizationResponses.add(modelMapper.map(organization, OrganizationResponse.class));
		}
		return organizationResponses;
	}
	
	@RequestMapping("/common/cities")
	public List<CityResponse> getCities() {
		List<City> cities = commonService.getCities();
		
		List<CityResponse> cityResponses = new ArrayList<>();
		for(City city : cities){
			List<String> localities = new ArrayList<>();
			for(Locality locality : city.getLocalities()) {
				localities.add(locality.getName());
			}
			cityResponses.add(new CityResponse(city.getName(), localities));
		}
		return cityResponses;
	}
	
	@RequestMapping("/common/cars")
	public List<VehicleResponse> getCars() {
		List<CarMake> carMakes = commonService.getCars();
		
		List<VehicleResponse> cars = new ArrayList<>();
		for(CarMake carMake : carMakes){
			List<String> models = new ArrayList<>();
			for(CarModel carModel : carMake.getCarModels()) {
				models.add(carModel.getModel());
			}
			cars.add(new VehicleResponse(carMake.getMake(), models));
		}
		return cars;
	}

	@RequestMapping("/common/bikes")
	public List<VehicleResponse> getBikes() {
		List<BikeMake> bikeMakes = commonService.getBikes();
		
		List<VehicleResponse> bikes = new ArrayList<>();
		for(BikeMake bikeMake : bikeMakes){
			List<String> models = new ArrayList<>();
			for(BikeModel bikeModel : bikeMake.getBikeModels()) {
				models.add(bikeModel.getModel());
			}
			bikes.add(new VehicleResponse(bikeMake.getMake(), models));
		}
		return bikes;
	}
	
}
