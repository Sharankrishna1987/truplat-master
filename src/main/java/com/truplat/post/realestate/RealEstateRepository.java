package com.truplat.post.realestate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface RealEstateRepository extends PagingAndSortingRepository<RealEstate, Integer> {
	
	List<RealEstate> findTop6ByCityOrderByModifiedDateDesc(String city);
	
	List<RealEstate> findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<RealEstate> findTop100ByCityOrderByModifiedDateDesc(String city);
	
	List<RealEstate> findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	List<RealEstate> findByCityOrderByModifiedDateDesc(String city);
	
	List<RealEstate> findByUserOrganizationNameAndCityOrderByModifiedDateDesc(String organizationName, String city);
	
	Optional<RealEstate> findByIdAndDeletedFalse(Integer id);
	
	@Query(value = "SELECT * FROM real_estate re INNER JOIN user as u ON re.user_id = u.user_id INNER JOIN organization as o ON u.organization_id = o.id WHERE o.name = ?1 "
						+ " AND re.city = ?2 AND MATCH(re.title, re.description) AGAINST(?3 IN NATURAL LANGUAGE MODE) ORDER BY re.modified_date desc",
			nativeQuery = true)
	List<RealEstate> searchWithRestrictedAccess(String organizationName, String city, String searchText);
	
	@Query(value = "SELECT * FROM real_estate re  WHERE re.city = ?1 AND MATCH(re.title, re.description) AGAINST(?2 IN NATURAL LANGUAGE MODE) ORDER BY re.modified_date desc",
			nativeQuery = true)
	List<RealEstate> search(String city, String searchText);	
}
