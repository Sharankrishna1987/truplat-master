package com.truplat.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truplat.common.data.City;
import com.truplat.common.data.Organization;
import com.truplat.post.automobile.BikeMake;
import com.truplat.post.automobile.BikeMakeRepository;
import com.truplat.post.automobile.CarMake;
import com.truplat.post.automobile.CarMakeRepository;

@Service
public class CommonService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CarMakeRepository carMakeRepository;
	
	@Autowired
	private BikeMakeRepository bikeMakeRepository;
	
	@Cacheable("organizations")
	public List<Organization> getOrganizations() {
		return organizationRepository.findByActive(true);

	}
	
	@Cacheable("cities")
	public List<City> getCities() {
		return cityRepository.findByActive(true);

	}
	
	@Cacheable("cars")
	public List<CarMake> getCars() {
		return carMakeRepository.findByActive(true);

	}
	
	@Cacheable("bikes")
	public List<BikeMake> getBikes() {
		return bikeMakeRepository.findByActive(true);

	}
	
}
