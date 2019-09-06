package com.truplat.post.automobile;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AutomobileRepository extends PagingAndSortingRepository<Automobile, Integer> {
	
	List<Automobile> findTop6ByCityOrderByModifiedDateDesc(String city);
	
	List<Automobile> findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<Automobile> findTop100ByCityOrderByModifiedDateDesc(String city);
	
	List<Automobile> findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<Automobile> findByCityOrderByModifiedDateDesc(String city);
	
	List<Automobile> findByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	Optional<Automobile> findByIdAndDeletedFalse(Integer id);
	
	@Query(value = "SELECT * FROM automobile a INNER JOIN user as u ON a.user_id = u.user_id INNER JOIN organization as o ON u.organization_id = o.id WHERE o.name = ?1 "
			+ " AND a.city = ?2 AND MATCH(a.title, a.description) AGAINST(?3 IN NATURAL LANGUAGE MODE) ORDER BY a.modified_date desc",
			nativeQuery = true)
	List<Automobile> searchWithRestrictedAccess(String organizationName, String city, String searchText);
	
	@Query(value = "SELECT * FROM automobile a  WHERE a.city = ?1 AND MATCH(a.title, a.description) AGAINST(?2 IN NATURAL LANGUAGE MODE) ORDER BY a.modified_date desc",
			nativeQuery = true)
	List<Automobile> search(String city, String searchText);	
}
