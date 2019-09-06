package com.truplat.post;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.truplat.common.Category;
import com.truplat.common.ImageService;
import com.truplat.common.exception.TruplatException;
import com.truplat.post.automobile.Automobile;
import com.truplat.post.automobile.AutomobileRepository;
import com.truplat.post.automobile.AutomobileRequest;
import com.truplat.post.automobile.AutomobileResponse;
import com.truplat.post.automobile.FuelType;
import com.truplat.post.automobile.VehicleType;
import com.truplat.post.electronic.Electronic;
import com.truplat.post.electronic.ElectronicRepository;
import com.truplat.post.electronic.ElectronicRequest;
import com.truplat.post.electronic.ElectronicResponse;
import com.truplat.post.electronic.ElectronicType;
import com.truplat.post.lifestyle.Lifestyle;
import com.truplat.post.lifestyle.LifestyleRepository;
import com.truplat.post.lifestyle.LifestyleRequest;
import com.truplat.post.lifestyle.LifestyleResponse;
import com.truplat.post.lifestyle.LifestyleType;
import com.truplat.post.realestate.PropertyType;
import com.truplat.post.realestate.RealEstate;
import com.truplat.post.realestate.RealEstateRepository;
import com.truplat.post.realestate.RealEstateRequest;
import com.truplat.post.realestate.RealEstateResponse;
import com.truplat.post.realestate.TransactionType;
import com.truplat.usermanagement.User;

@Service
public class PostService {
	
	private static final String LIFESTYLE_FOLDER_NAME = "lifestyle";

	private static final String ELECTRONIC_FOLDER_NAME = "electronic";

	private static final String AUTOMOBLE_FOLDER_NAME = "automobile";

	private static final String REAL_ESTATE_FOLDER_NAME = "real_estate";
	
	private static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance();

	@Value("${application.url}")
	private String applicationURL;
	
	@Value("${image.unavailable.url}")
	private String imageUnavailableURL;	
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	@Autowired
	private AutomobileRepository automobileRepository;
	
	@Autowired
	private ElectronicRepository electronicRepository;
	
	@Autowired
	private LifestyleRepository lifestyleRepository;
	
	@Autowired
	private BookmarkRepository bookmarkRepository;
	
	@Autowired
	private ImageService imageService;
	
	@Value( "${file.location}" )
	private String fileLocation;
	
	@Transactional
	public void saveRealEstate(RealEstateRequest realEstateRequest, MultipartFile[] files, User user) throws IOException {
		
		ModelMapper modelMapper = new ModelMapper();
		RealEstate realEstate = modelMapper.map(realEstateRequest, RealEstate.class);
		realEstate.setUser(user);
		if(files.length > 0){
			realEstate.setImageName1(files[0].getOriginalFilename());
		}
		if(files.length > 1){
			realEstate.setImageName2(files[1].getOriginalFilename());
		}
		if(files.length > 2){
			realEstate.setImageName3(files[2].getOriginalFilename());
		}
		if(files.length > 3){
			realEstate.setImageName4(files[3].getOriginalFilename());
		}
		if(files.length > 4){
			realEstate.setImageName5(files[4].getOriginalFilename());
		}	

		RealEstate result = realEstateRepository.save(realEstate);
		String folderPath = fileLocation + REAL_ESTATE_FOLDER_NAME + File.separator + result.getId().toString();
		saveFiles(files, folderPath);
	}
	
	@Transactional
	public void saveAutomobile(AutomobileRequest automobileRequest, MultipartFile[] files, User user) throws IOException {
		
		ModelMapper modelMapper = new ModelMapper();
		Automobile automobile = modelMapper.map(automobileRequest, Automobile.class);
		automobile.setUser(user);
		if(files.length > 0){
			automobile.setImageName1(files[0].getOriginalFilename());
		}
		if(files.length > 1){
			automobile.setImageName2(files[1].getOriginalFilename());
		}
		if(files.length > 2){
			automobile.setImageName3(files[2].getOriginalFilename());
		}
		if(files.length > 3){
			automobile.setImageName4(files[3].getOriginalFilename());
		}
		if(files.length > 4){
			automobile.setImageName5(files[4].getOriginalFilename());
		}	
		
		Automobile result = automobileRepository.save(automobile);
		String folderPath = fileLocation + AUTOMOBLE_FOLDER_NAME + File.separator + result.getId().toString();
		saveFiles(files, folderPath);
	}
	
	@Transactional
	public void saveElectronic(ElectronicRequest electronicRequest, MultipartFile[] files, User user) throws IOException {
		
		ModelMapper modelMapper = new ModelMapper();
		Electronic electronic = modelMapper.map(electronicRequest, Electronic.class);
		electronic.setUser(user);
		if(files.length > 0){
			electronic.setImageName1(files[0].getOriginalFilename());
		}
		if(files.length > 1){
			electronic.setImageName2(files[1].getOriginalFilename());
		}
		if(files.length > 2){
			electronic.setImageName3(files[2].getOriginalFilename());
		}
		if(files.length > 3){
			electronic.setImageName4(files[3].getOriginalFilename());
		}
		if(files.length > 4){
			electronic.setImageName5(files[4].getOriginalFilename());
		}	
		
		Electronic result = electronicRepository.save(electronic);		
		String folderPath = fileLocation + ELECTRONIC_FOLDER_NAME + File.separator + result.getId().toString();
		saveFiles(files, folderPath);
	}
	
	@Transactional
	public void saveLifestyle(LifestyleRequest lifestyleRequest, MultipartFile[] files, User user) throws IOException {
		
		ModelMapper modelMapper = new ModelMapper();
		Lifestyle lifestyle = modelMapper.map(lifestyleRequest, Lifestyle.class);
		lifestyle.setUser(user);
		if(files.length > 0){
			lifestyle.setImageName1(files[0].getOriginalFilename());
		}
		if(files.length > 1){
			lifestyle.setImageName2(files[1].getOriginalFilename());
		}
		if(files.length > 2){
			lifestyle.setImageName3(files[2].getOriginalFilename());
		}
		if(files.length > 3){
			lifestyle.setImageName4(files[3].getOriginalFilename());
		}
		if(files.length > 4){
			lifestyle.setImageName5(files[4].getOriginalFilename());
		}	
		
		Lifestyle result = lifestyleRepository.save(lifestyle);
		String folderPath = fileLocation + LIFESTYLE_FOLDER_NAME + File.separator + result.getId().toString();
		saveFiles(files, folderPath);
	}

	private void saveFiles(MultipartFile[] files, String folderPath) throws IOException {
		new File(folderPath).mkdir();
		
		if(files != null && files.length > 0 ){
			for(MultipartFile file : files){
				String fileName = file.getOriginalFilename();
				BufferedImage resizedImage = imageService.resize(ImageIO.read(file.getInputStream()));		
				File outputFile = new File(folderPath + File.separator + fileName);
				ImageIO.write(resizedImage, imageService.getFormatName(fileName), outputFile);
			}
		}
	}
	
	public List<Post> getLatestPosts(User user, String city) {
		
		String organizationName = user.getOrganization().getName();
		
		List<Post> posts = new ArrayList<>();
		
		List<RealEstate> realEstates = "yes".equals(user.getRestrictedAccess()) 
				? realEstateRepository.findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: realEstateRepository.findTop100ByCityOrderByModifiedDateDesc(city);
		
		addRealEstatesToPosts(posts, realEstates);
		
		List<Automobile> automobiles = "yes".equals(user.getRestrictedAccess()) 
				? automobileRepository.findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: automobileRepository.findTop100ByCityOrderByModifiedDateDesc(city);
		
		addAutomobilesToPosts(posts, automobiles);
		
		List<Electronic> electronics = "yes".equals(user.getRestrictedAccess()) 
				? electronicRepository.findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: electronicRepository.findTop100ByCityOrderByModifiedDateDesc(city);
		
		addElectronicsToPosts(posts, electronics);
		
		List<Lifestyle> lifestyles = "yes".equals(user.getRestrictedAccess()) 
				? lifestyleRepository.findTop100ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: lifestyleRepository.findTop100ByCityOrderByModifiedDateDesc(city);
		
		addLifestylesToPosts(posts, lifestyles);
		
		posts.sort(Comparator.comparing(Post::getModifiedDate).reversed());
		if(posts.size() > 100) {
			return posts.subList(0, 100);
		}
		
		List<Bookmark> bookmarks = bookmarkRepository.findByUserUserId(user.getUserId());
		if(bookmarks != null){
			addBookmark(posts, bookmarks);
		}
		
		return posts;		
	}

	public List<Post> getTopLatestPosts(User user, String city) {
		
		String organizationName = user.getOrganization().getName();
		
		List<Post> posts = new ArrayList<>();
		
		List<RealEstate> realEstates = "yes".equals(user.getRestrictedAccess()) 
				? realEstateRepository.findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: realEstateRepository.findTop6ByCityOrderByModifiedDateDesc(city);
		
		addRealEstatesToPosts(posts, realEstates);
		
		List<Automobile> automobiles = "yes".equals(user.getRestrictedAccess()) 
				? automobileRepository.findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: automobileRepository.findTop6ByCityOrderByModifiedDateDesc(city);
		
		addAutomobilesToPosts(posts, automobiles);
		
		List<Electronic> electronics = "yes".equals(user.getRestrictedAccess()) 
				? electronicRepository.findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: electronicRepository.findTop6ByCityOrderByModifiedDateDesc(city);
		
		addElectronicsToPosts(posts, electronics);
		
		List<Lifestyle> lifestyles = "yes".equals(user.getRestrictedAccess()) 
				? lifestyleRepository.findTop6ByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city) 
						: lifestyleRepository.findTop6ByCityOrderByModifiedDateDesc(city);
		
		addLifestylesToPosts(posts, lifestyles);
		if(posts.size() > 6) {
			posts = posts.subList(0, 6);
		}
		
		if(posts.isEmpty() == false) {
			List<Bookmark> bookmarks = bookmarkRepository.findByUserUserId(user.getUserId());
			if(bookmarks != null){
				addBookmark(posts, bookmarks);
			}
		}
	
		return posts;		
	}
	
	public List<Post> getBookmarkedPosts(User user) {
		
		List<Post> posts = new ArrayList<>();
		
		List<Bookmark> bookmarks = bookmarkRepository.findByUserUserId(user.getUserId());
		
		for(Bookmark bookmark : bookmarks) {
			if(bookmark.getCategoryName().equals("real_estate")){
				addRealEstateToPosts(posts, realEstateRepository.findByIdAndDeletedFalse(bookmark.getPostId()).orElse(null));
			} else if(bookmark.getCategoryName().equals("automobile")) {
				addAutomobileToPosts(posts, automobileRepository.findByIdAndDeletedFalse(bookmark.getPostId()).orElse(null));
			} else if(bookmark.getCategoryName().equals("electronic")) {
				addElectronicToPosts(posts, electronicRepository.findByIdAndDeletedFalse(bookmark.getPostId()).orElse(null));
			} else if(bookmark.getCategoryName().equals("lifestyle")) {
				addLifestyleToPosts(posts, lifestyleRepository.findByIdAndDeletedFalse(bookmark.getPostId()).orElse(null));
			}		
		}
		return posts;
	}
	
	public List<Post> getTopBookmarkedPosts(User user) {		
		
		List<Post> posts = getBookmarkedPosts(user);
		if(posts.size() > 6) {
			return posts.subList(0, 6);
		}		
		return posts;
	}
	
	public List<Post> searchPost(FilterPostRequest filterPostRequest, User user) {
		
		String organizationName = user.getOrganization().getName();
		String city = filterPostRequest.getCity();		
		
		List<Post> posts = new ArrayList<>();
		
		if(Category.REAL_ESTATE.getId().equals(filterPostRequest.getCategoryId())) {
			
			List<RealEstate> realEstates = Collections.emptyList();
			if("yes".equals(user.getRestrictedAccess()) ) {
				realEstates = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
								? realEstateRepository.findByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city)						
								: realEstateRepository.searchWithRestrictedAccess(organizationName, city, filterPostRequest.getKeywords());
								
			} else {
				realEstates = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
						? realEstateRepository.findByCityOrderByModifiedDateDesc(city)						
						: realEstateRepository.search(city, filterPostRequest.getKeywords());
			}
			
			addRealEstatesToPosts(posts, realEstates);
			
		} else if(Category.AUTOMOBILE.getId().equals(filterPostRequest.getCategoryId())) {
			
			List<Automobile> automobiles = Collections.emptyList();
			if("yes".equals(user.getRestrictedAccess()) ) {
				automobiles = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
								? automobileRepository.findByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city)						
								: automobileRepository.searchWithRestrictedAccess(organizationName, city, filterPostRequest.getKeywords());
								
			} else {
				automobiles = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
						? automobileRepository.findByCityOrderByModifiedDateDesc(city)						
						: automobileRepository.search(city, filterPostRequest.getKeywords());
			}
					
			addAutomobilesToPosts(posts, automobiles);
		} else if(Category.ELECTRONIC.getId().equals(filterPostRequest.getCategoryId())) {
			
			List<Electronic> electronics = Collections.emptyList();
			if("yes".equals(user.getRestrictedAccess()) ) {
				electronics = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
								? electronicRepository.findByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city)						
								: electronicRepository.searchWithRestrictedAccess(organizationName, city, filterPostRequest.getKeywords());
								
			} else {
				electronics = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
						? electronicRepository.findByCityOrderByModifiedDateDesc(city)						
						: electronicRepository.search(city, filterPostRequest.getKeywords());
			}
			
			addElectronicsToPosts(posts, electronics);
		} else if(Category.LIFESTYLE.getId().equals(filterPostRequest.getCategoryId())) {
			
			List<Lifestyle> lifestyles = Collections.emptyList();
			if("yes".equals(user.getRestrictedAccess()) ) {
				lifestyles = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
								? lifestyleRepository.findByUserOrganizationNameAndCityOrderByModifiedDateDesc(organizationName, city)						
								: lifestyleRepository.searchWithRestrictedAccess(organizationName, city, filterPostRequest.getKeywords());
								
			} else {
				lifestyles = filterPostRequest.getKeywords() == null || filterPostRequest.getKeywords().isEmpty() 
						? lifestyleRepository.findByCityOrderByModifiedDateDesc(city)						
						: lifestyleRepository.search(city, filterPostRequest.getKeywords());
			}
					
			addLifestylesToPosts(posts, lifestyles);
		}
		
		if(posts.isEmpty() == false) {
			List<Bookmark> bookmarks = bookmarkRepository.findByUserUserId(user.getUserId());
			if(bookmarks != null){
				addBookmark(posts, bookmarks);
			}
		}		
		return posts;
	}
	
	private List<Post> addBookmark(List<Post> posts, List<Bookmark> bookmarks) {
		for(Bookmark bookmark : bookmarks){
			Post post = posts.stream()
	        .filter(p -> p.getCategoryName().equals(bookmark.getCategoryName()) && p.getId().equals(bookmark.getPostId())).findFirst().orElse(null);
			if(post != null) {
				post.setBookmarked(true);
			} else {
				bookmarkRepository.delete(bookmark);
			}
	        
		}
		return posts;
	}

	public RealEstateResponse getRealEstate(Integer id) {
		
		RealEstate realEstate = realEstateRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TruplatException("Real Estate post does not exist"));	

		Set<String> imageSet = new HashSet<>();
		imageSet.add(getImageURL(id.toString(), realEstate.getImageName1(), Category.REAL_ESTATE));
		imageSet.add(getImageURL(id.toString(), realEstate.getImageName2(), Category.REAL_ESTATE));
		imageSet.add(getImageURL(id.toString(), realEstate.getImageName3(), Category.REAL_ESTATE));
		imageSet.add(getImageURL(id.toString(), realEstate.getImageName4(), Category.REAL_ESTATE));
		imageSet.add(getImageURL(id.toString(), realEstate.getImageName5(), Category.REAL_ESTATE));
		
		if(imageSet.size() > 1 && imageSet.contains(imageUnavailableURL)){
			imageSet.remove(imageUnavailableURL);
		}
		
		String [] images = new String[imageSet.size()];
		imageSet.toArray(images);
		
		RealEstateResponse realEstateResponse = new RealEstateResponse.Builder()
												.id(realEstate.getId().toString())
												.transactionType(TransactionType.getLabel(realEstate.getTransactionType()))
												.propertyType(PropertyType.getLabel(realEstate.getPropertyType()))
												.unitType(realEstate.getUnitType())
												.locality(realEstate.getLocality())
												.city(realEstate.getCity())
												.area(NUMBER_FORMATTER.format(Integer.parseInt(realEstate.getArea())))
												.amount(NUMBER_FORMATTER.format(Integer.parseInt(realEstate.getAmount())))
												.title(realEstate.getTitle())
												.description(realEstate.getDescription())
												.images(images)
												.postedBy(getFullName(realEstate.getUser()))
												.organizationName(realEstate.getUser().getOrganization().getName())
												.contactNumber(realEstate.getUser().getContactNumber())
												.emailAddress(realEstate.getUser().getPersonalEmailAddress())
												.build();
		return realEstateResponse;

	}
	
	public AutomobileResponse getAutomobile(Integer id) {
		
		Automobile automobile = automobileRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TruplatException("Automobile post does not exist"));	

		Set<String> imageSet = new HashSet<>();
		imageSet.add(getImageURL(id.toString(), automobile.getImageName1(), Category.AUTOMOBILE));
		imageSet.add(getImageURL(id.toString(), automobile.getImageName2(), Category.AUTOMOBILE));
		imageSet.add(getImageURL(id.toString(), automobile.getImageName3(), Category.AUTOMOBILE));
		imageSet.add(getImageURL(id.toString(), automobile.getImageName4(), Category.AUTOMOBILE));
		imageSet.add(getImageURL(id.toString(), automobile.getImageName5(), Category.AUTOMOBILE));
		
		if(imageSet.size() > 1 && imageSet.contains(imageUnavailableURL)){
			imageSet.remove(imageUnavailableURL);
		}
		
		String [] images = new String[imageSet.size()];
		imageSet.toArray(images);
		
		AutomobileResponse automobileResponse = new AutomobileResponse.Builder()
												.id(automobile.getId().toString())
												.vehicleType(VehicleType.getLabel(automobile.getVehicleType()))
												.fuelType(FuelType.getLabel(automobile.getFuelType()))
												.make(automobile.getMake())
												.model(automobile.getModel())
												.locality(automobile.getLocality())
												.city(automobile.getCity())
												.driven(NUMBER_FORMATTER.format(Integer.parseInt(automobile.getDriven())))
												.amount(NUMBER_FORMATTER.format(Integer.parseInt(automobile.getAmount())))
												.title(automobile.getTitle())
												.description(automobile.getDescription())
												.images(images)
												.postedBy(getFullName(automobile.getUser()))
												.organizationName(automobile.getUser().getOrganization().getName())
												.contactNumber(automobile.getUser().getContactNumber())
												.emailAddress(automobile.getUser().getPersonalEmailAddress())
												.build();
		return automobileResponse;

	}
	
	public ElectronicResponse getElectronic(Integer id) {
		
		Electronic electronic = electronicRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TruplatException("Electronic post does not exist"));	

		Set<String> imageSet = new HashSet<>();
		imageSet.add(getImageURL(id.toString(), electronic.getImageName1(), Category.ELECTRONIC));
		imageSet.add(getImageURL(id.toString(), electronic.getImageName2(), Category.ELECTRONIC));
		imageSet.add(getImageURL(id.toString(), electronic.getImageName3(), Category.ELECTRONIC));
		imageSet.add(getImageURL(id.toString(), electronic.getImageName4(), Category.ELECTRONIC));
		imageSet.add(getImageURL(id.toString(), electronic.getImageName5(), Category.ELECTRONIC));
		
		if(imageSet.size() > 1 && imageSet.contains(imageUnavailableURL)){
			imageSet.remove(imageUnavailableURL);
		}
		
		String [] images = new String[imageSet.size()];
		imageSet.toArray(images);		
		
		ElectronicResponse electronicResponse = new ElectronicResponse.Builder()
												.id(electronic.getId().toString())
												.electronicType(ElectronicType.getName(electronic.getElectronicType()))
												.locality(electronic.getLocality())
												.city(electronic.getCity())
												.amount(NUMBER_FORMATTER.format(Integer.parseInt(electronic.getAmount())))
												.title(electronic.getTitle())
												.description(electronic.getDescription())
												.images(images)
												.postedBy(getFullName(electronic.getUser()))
												.organizationName(electronic.getUser().getOrganization().getName())
												.contactNumber(electronic.getUser().getContactNumber())
												.emailAddress(electronic.getUser().getPersonalEmailAddress())
												.build();
		return electronicResponse;

	}
	
	public LifestyleResponse getLifestyle(Integer id) {
		
		Lifestyle lifestyle = lifestyleRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new TruplatException("Lifestyle post does not exist"));	

		Set<String> imageSet = new HashSet<>();
		imageSet.add(getImageURL(id.toString(), lifestyle.getImageName1(), Category.LIFESTYLE));
		imageSet.add(getImageURL(id.toString(), lifestyle.getImageName2(), Category.LIFESTYLE));
		imageSet.add(getImageURL(id.toString(), lifestyle.getImageName3(), Category.LIFESTYLE));
		imageSet.add(getImageURL(id.toString(), lifestyle.getImageName4(), Category.LIFESTYLE));
		imageSet.add(getImageURL(id.toString(), lifestyle.getImageName5(), Category.LIFESTYLE)); 
		
		if(imageSet.size() > 1 && imageSet.contains(imageUnavailableURL)){
			imageSet.remove(imageUnavailableURL);
		}
		
		String [] images = new String[imageSet.size()];
		imageSet.toArray(images);		
		
		LifestyleResponse lifestyleResponse = new LifestyleResponse.Builder()
												.id(lifestyle.getId().toString())
												.lifestyleType(LifestyleType.getName(lifestyle.getLifestyleType()))
												.locality(lifestyle.getLocality())
												.city(lifestyle.getCity())
												.amount(NUMBER_FORMATTER.format(Integer.parseInt(lifestyle.getAmount())))
												.title(lifestyle.getTitle())
												.description(lifestyle.getDescription())
												.images(images)
												.postedBy(getFullName(lifestyle.getUser()))
												.organizationName(lifestyle.getUser().getOrganization().getName())
												.contactNumber(lifestyle.getUser().getContactNumber())
												.emailAddress(lifestyle.getUser().getPersonalEmailAddress())
												.build();
		return lifestyleResponse;

	}
	
	@Transactional
	public void bookmarkPost(Bookmark bookmark, boolean bookmarkPost) {
		
		if(bookmarkPost){
			bookmarkRepository.deleteByPostIdAndCategoryNameAndUserUserId(bookmark.getPostId(), bookmark.getCategoryName(), bookmark.getUser().getUserId());
		} else {
			bookmarkRepository.save(bookmark);
		}
	}

	private void addLifestylesToPosts(List<Post> posts, List<Lifestyle> lifestyles) {
		for(Lifestyle lifestyle : lifestyles){
			addLifestyleToPosts(posts, lifestyle);
		}
	}
	
	private void addLifestyleToPosts(List<Post> posts, Lifestyle lifestyle) {
		if(lifestyle == null){
			return;
		}
		posts.add(new Post(lifestyle.getId(),lifestyle.getTitle(), getImageURL(lifestyle.getId().toString(), lifestyle.getImageName1(), Category.LIFESTYLE), Category.LIFESTYLE.name().toLowerCase(), false, getFullName(lifestyle.getUser()), 
				lifestyle.getUser().getOrganization().getName(), lifestyle.getModifiedDate()));

	}

	private void addElectronicsToPosts(List<Post> posts, List<Electronic> electronics) {
		for(Electronic electronic : electronics){
			addElectronicToPosts(posts, electronic);
		}
	}

	private void addElectronicToPosts(List<Post> posts, Electronic electronic) {
		if(electronic == null){
			return;
		}
		posts.add(new Post(electronic.getId(),electronic.getTitle(), getImageURL(electronic.getId().toString(), electronic.getImageName1(), Category.ELECTRONIC), Category.ELECTRONIC.name().toLowerCase(), false, getFullName(electronic.getUser()), 
					electronic.getUser().getOrganization().getName(), electronic.getModifiedDate()));
	}
	
	private void addAutomobilesToPosts(List<Post> posts, List<Automobile> automobiles) {
		for(Automobile automobile : automobiles){
			addAutomobileToPosts(posts, automobile);
		}
	}

	private void addAutomobileToPosts(List<Post> posts, Automobile automobile) {
		if(automobile == null){
			return;
		}
		posts.add(new Post(automobile.getId(),automobile.getTitle(), getImageURL(automobile.getId().toString(), automobile.getImageName1(), Category.AUTOMOBILE), Category.AUTOMOBILE.name().toLowerCase(), false, getFullName(automobile.getUser()), 
					automobile.getUser().getOrganization().getName(), automobile.getModifiedDate()));
	}
	
	private void addRealEstatesToPosts(List<Post> posts, List<RealEstate> realEstates) {
		for(RealEstate realEstate : realEstates){
			addRealEstateToPosts(posts, realEstate);
		}
	}

	private void addRealEstateToPosts(List<Post> posts, RealEstate realEstate) {
		if(realEstate == null){
			return;
		}
		posts.add(new Post(realEstate.getId(),realEstate.getTitle(), getImageURL(realEstate.getId().toString(), realEstate.getImageName1(), Category.REAL_ESTATE), Category.REAL_ESTATE.name().toLowerCase(), false, getFullName(realEstate.getUser()), 
					realEstate.getUser().getOrganization().getName(), realEstate.getModifiedDate()));
	}
	
	private String getImageURL(String id, String imageName, Category category) {
		if(id == null || imageName == null || category == null){
			return imageUnavailableURL;
		}
		return applicationURL + category.name().toLowerCase() + "/" + id + "/" + imageName;
	}
	
	private String getFullName(User user) {
		return user.getFirstName() + " " + user.getLastName();
	}
	
}
