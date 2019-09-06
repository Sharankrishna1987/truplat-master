package com.truplat.post.lifestyle;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface LifestyleRepository extends PagingAndSortingRepository<Lifestyle, Integer> {
	
	List<Lifestyle> findTop6ByCityOrderByModifiedDateDesc(String city);
	
	List<Lifestyle> findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<Lifestyle> findTop100ByCityOrderByModifiedDateDesc(String city);
	
	List<Lifestyle> findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<Lifestyle> findByCityOrderByModifiedDateDesc(String city);
	
	List<Lifestyle> findByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	Optional<Lifestyle> findByIdAndDeletedFalse(Integer id);
	
	@Query(value = "SELECT * FROM lifestyle l INNER JOIN user as u ON l.user_id = u.user_id INNER JOIN organization as o ON u.organization_id = o.id WHERE o.name = ?1 "
			+ " AND l.city = ?2 AND MATCH(l.title, l.description) AGAINST(?3 IN NATURAL LANGUAGE MODE) ORDER BY l.modified_date desc",
			nativeQuery = true)
	List<Lifestyle> searchWithRestrictedAccess(String organizationName, String city, String searchText);
	
	@Query(value = "SELECT * FROM lifestyle l  WHERE l.city = ?1 AND MATCH(l.title, l.description) AGAINST(?2 IN NATURAL LANGUAGE MODE) ORDER BY l.modified_date desc",
			nativeQuery = true)
	List<Lifestyle> search(String city, String searchText);
}
