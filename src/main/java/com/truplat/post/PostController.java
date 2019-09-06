package com.truplat.post;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.truplat.common.UserSession;
import com.truplat.post.automobile.AutomobileRequest;
import com.truplat.post.automobile.AutomobileResponse;
import com.truplat.post.electronic.ElectronicRequest;
import com.truplat.post.electronic.ElectronicResponse;
import com.truplat.post.lifestyle.LifestyleRequest;
import com.truplat.post.lifestyle.LifestyleResponse;
import com.truplat.post.realestate.RealEstateRequest;
import com.truplat.post.realestate.RealEstateResponse;
import com.truplat.usermanagement.User;

@RestController
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserSession userSession;
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/saveRealEstate")
	public ResponseEntity<String> saveRealEstate(@ModelAttribute @Valid RealEstateRequest realEstateRequest, @RequestParam(name="files", required=false) MultipartFile[] files) throws IOException {
		User currentUser = userSession.getCurrentUser();
		postService.saveRealEstate(realEstateRequest, files, currentUser);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/saveAutomobile")
	public ResponseEntity<String> saveAutomobile(@ModelAttribute @Valid AutomobileRequest automobileRequest, @RequestParam(name="files", required=false) MultipartFile[] files) throws IOException {
		
		User currentUser = userSession.getCurrentUser();
		postService.saveAutomobile(automobileRequest, files, currentUser);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/saveElectronic")
	public ResponseEntity<String> saveElectronic(@ModelAttribute @Valid ElectronicRequest electronicRequest, @RequestParam(name="files", required=false) MultipartFile[] files) throws IOException {
		
		User currentUser = userSession.getCurrentUser();
		postService.saveElectronic(electronicRequest, files, currentUser);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/saveLifestyle")
	public ResponseEntity<String> saveLifestyle(@ModelAttribute @Valid LifestyleRequest lifestyleRequest, @RequestParam(name="files", required=false) MultipartFile[] files) throws IOException {
		
		User currentUser = userSession.getCurrentUser();
		postService.saveLifestyle(lifestyleRequest, files, currentUser);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/latest")
	public List<Post> getLatestPosts(@RequestBody FilterPostRequest filterPostRequest) {
		return postService.getLatestPosts(userSession.getCurrentUser(), filterPostRequest.getCity());
	}
	
	@RequestMapping(value = "/post/bookmarked")
	public List<Post> getBookmarkedPosts() {
		return postService.getBookmarkedPosts(userSession.getCurrentUser());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/top/latest")
	public List<Post> getTopLatestPosts(@RequestBody FilterPostRequest filterPostRequest) {
		return postService.getTopLatestPosts(userSession.getCurrentUser(), filterPostRequest.getCity());
	}
	
	@RequestMapping(value = "/post/top/bookmarked")
	public List<Post> getTopBookmarkedPosts() {
		return postService.getTopBookmarkedPosts(userSession.getCurrentUser());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post/viewRealEstate/{id}")
	public RealEstateResponse viewRealEstate(@PathVariable Integer id) {
		return postService.getRealEstate(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post/viewAutomobile/{id}")
	public AutomobileResponse viewAutomobile(@PathVariable Integer id) {
		return postService.getAutomobile(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post/viewElectronic/{id}")
	public ElectronicResponse viewElectronic(@PathVariable Integer id) {
		return postService.getElectronic(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post/viewLifestyle/{id}")
	public LifestyleResponse viewLifestyle(@PathVariable Integer id) {
		return postService.getLifestyle(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/post/bookmark/{categoryName}/{id}/{bookmark}")
	public ResponseEntity<String> bookmarkPost(@PathVariable String categoryName, @PathVariable Integer id, @PathVariable boolean bookmark) {
		postService.bookmarkPost(new Bookmark(null, id, categoryName, userSession.getCurrentUser(), null), bookmark);
		return ResponseEntity.ok("success");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/post/searchPost")
	public List<Post> searchPost(@RequestBody FilterPostRequest filterPostRequest) {
		return postService.searchPost(filterPostRequest, userSession.getCurrentUser());
	}

}
