package com.truplat.common;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.truplat.common.data.Organization;

@RepositoryRestResource(exported = false)
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

	List<Organization> findByActive(boolean active);
}
