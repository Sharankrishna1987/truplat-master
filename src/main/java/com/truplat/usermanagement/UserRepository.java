package com.truplat.usermanagement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByOfficialEmailAddress(String officialEmailAddress);
	
	User findByPersonalEmailAddressAndActive(String personalEmailAddress, boolean active);
	
}
