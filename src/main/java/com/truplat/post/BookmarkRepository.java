package com.truplat.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface BookmarkRepository extends CrudRepository<Bookmark, Integer> {
	
	long deleteByPostIdAndCategoryNameAndUserUserId(Integer postId, String categoryName, Integer userId);
	
	List<Bookmark> findByUserUserId(Integer userId);
}
