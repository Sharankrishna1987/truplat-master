package com.truplat.post.electronic;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ElectronicRepository extends PagingAndSortingRepository<Electronic, Integer> {
	
	List<Electronic> findTop6ByCityOrderByModifiedDateDesc(String city);
	
	List<Electronic> findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<Electronic> findTop100ByCityOrderByModifiedDateDesc(String city);
	
	List<Electronic> findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<Electronic> findByCityOrderByModifiedDateDesc(String city);
	
	List<Electronic> findByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	Optional<Electronic> findByIdAndDeletedFalse(Integer id);
	
	@Query(value = "SELECT * FROM electronic e INNER JOIN user as u ON e.user_id = u.user_id INNER JOIN organization as o ON u.organization_id = o.id WHERE o.name = ?1 "
			+ " AND e.city = ?2 AND MATCH(e.title, e.description) AGAINST(?3 IN NATURAL LANGUAGE MODE) ORDER BY e.modified_date desc",
			nativeQuery = true)
	List<Electronic> searchWithRestrictedAccess(String organizationName, String city, String searchText);
	
	@Query(value = "SELECT * FROM electronic e  WHERE e.city = ?1 AND MATCH(e.title, e.description) AGAINST(?2 IN NATURAL LANGUAGE MODE) ORDER BY e.modified_date desc",
			nativeQuery = true)
	List<Electronic> search(String city, String searchText);
	
}
