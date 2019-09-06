package com.truplat.common;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.truplat.common.data.City;

@RepositoryRestResource(exported = false)
public interface CityRepository extends CrudRepository<City, Integer> {

	List<City> findByActive(boolean active);
}
