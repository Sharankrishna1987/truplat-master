package com.truplat.post.automobile;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CarMakeRepository extends CrudRepository<CarMake, Integer> {

	List<CarMake> findByActive(boolean active);
}
