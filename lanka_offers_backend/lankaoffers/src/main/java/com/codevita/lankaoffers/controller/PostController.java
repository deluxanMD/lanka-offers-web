package com.codevita.lankaoffers.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codevita.lankaoffers.entity.Images;
import com.codevita.lankaoffers.entity.Post;
import com.codevita.lankaoffers.service.ImageStorageService;
import com.codevita.lankaoffers.service.PostService;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.FilterManager;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;
import com.codevita.lankaoffers.util.Validator;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**
 * 
 * @author HARILOJUNAN NITHIYANANTHAN
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(AppConstants.BASE_URL)
public class PostController {
	GenericResult validateResult;
	
	@Autowired
	ImageStorageService imageStorageServices;
	
	@Autowired
	PostService postService;
	
	// Get all Post
	@GetMapping(AppConstants.POST_URL)
	public ResponseEntity<?> getAll(HttpServletRequest request) {
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);

			List<Post> dataList = postService.getAll(pagination, filters, null);

			if (dataList != null) {
				result.setData(dataList);
				result.setMsg(AppConstants.MSG_SUCCESS);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} else {
				result.setData(null);
				result.setMsg(AppConstants.MSG_FAILED);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception e) {
			result.setData(null);
			result.setMsg(AppConstants.MSG_FAILED);
			result.setSuccess(true);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}

	// Get one
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@GetMapping(AppConstants.POST_BY_ID_URL)
	public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			result = postService.getOne(id);

			if (result.isSuccess()) {
				return new ResponseEntity<>(result, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception e) {
			result = new GenericResult();
			result.setData(null);
			result.setMsg(e.getMessage());
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	//Post Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PostMapping(AppConstants.POST_URL)
	public ResponseEntity<Object> store(@RequestBody Post post) {
		GenericResult result = new GenericResult();
		try {
			// validation
			validateResult = Validator.validateNumber(post.getId(), "Id");
			if (!validateResult.isSuccess()) {
				result = validateResult;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}

			result = postService.store(post);

			if (!result.isSuccess()) {
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			} else {
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			result = new GenericResult();
			result.setData(null);
			result.setMsg(e.getMessage());
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	//Post Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PostMapping(AppConstants.UPLOAD_POST_IMAGE)
	public Images uploadImage(@RequestParam("image") MultipartFile file) {
	    String picName = imageStorageServices.storeImage(file);

	    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	            .path("/api/v1")
	            .path("/downloadImage/")
	            .path(picName)
	            .toUriString();

	    return new Images(picName, file.getContentType(), fileDownloadUri,
	    		 file.getSize());
	}	
			
	//Post Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PostMapping(AppConstants.UPLOAD_POST_MULTYPLE_IMAGES)
	public List<Images> uploadMultipleImages(@RequestParam("images") MultipartFile[] images) {
	    return Arrays.asList(images)
	            .stream()
	            .map(image -> uploadImage(image))
	            .collect(Collectors.toList());
	}	
		
	//Update Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PutMapping(AppConstants.POST_BY_ID_URL)
	public ResponseEntity<?> update(@RequestBody Post post, @PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			// validation
			validateResult = Validator.validateText(post.getTitle(), "Title");
			if (!validateResult.isSuccess()) {
				result = validateResult;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}

			result = postService.update(post);

			if (!result.isSuccess()) {
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			} else {
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			result = new GenericResult();
			result.setData(null);
			result.setMsg(e.getMessage());
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
		
	//Delete Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@DeleteMapping(AppConstants.POST_BY_ID_URL)
	public ResponseEntity<?> delete(@PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			result = postService.delete(id);

			if (!result.isSuccess()) {
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			} else {
				return new ResponseEntity<>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			result = new GenericResult();
			result.setData(null);
			result.setMsg(e.getMessage());
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	// Get Latest Post
	@GetMapping(AppConstants.POST_BY_CREATE_DATE)
	public ResponseEntity<?> getLatestPosts(HttpServletRequest request){
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<?> dataList = postService.getLatestPosts(pagination, filters);
			if (dataList != null) {
				result.setData(dataList);
				result.setMsg(AppConstants.MSG_SUCCESS);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				result.setData(null);
				result.setMsg(AppConstants.MSG_FAILED);
				result.setSuccess(false);
				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception e) {
			result.setData(null);
			result.setMsg(AppConstants.MSG_FAILED);
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
//	// Get Post By Categories
//	@GetMapping(AppConstants.POST_BY_POST_CATARGORIES)
//	public ResponseEntity<?> getPostByCategory(HttpServletRequest request,@PathVariable(name = "postcategory_id") long postcategory_id){
//		GenericResult result = new GenericResult();
//		try {
//			Pagination pagination = Pagination.formulatePaginationObject(request);
//			Map<String, String> filters = FilterManager.formulateFilterObject(request);
//			
//			List<?> dataList = postService.getPostByCategory(pagination, filters, postcategory_id);
//			if (dataList != null) {
//				result.setData(dataList);
//				result.setMsg(AppConstants.MSG_SUCCESS);
//				result.setSuccess(true);
//				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			}else {
//				result.setData(null);
//				result.setMsg(AppConstants.MSG_FAILED);
//				result.setSuccess(false);
//				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			}
//		} catch (Exception e) {
//			result.setData(null);
//			result.setMsg(AppConstants.MSG_FAILED);
//			result.setSuccess(false);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
	
	//get all post by particular categories
	@GetMapping("/getPostByCatagories/{postcategory_id}")
	public List<Post> getPostByCategory(@PathVariable(name = "postcategory_id") Long postcategory_id) {
		return postService.getPostByCategory(postcategory_id);
	}
	
	// Get Post Count By Categories
	@GetMapping(AppConstants.POST_COUNT_BY_POST_CATARGORIES)
	public ResponseEntity<?> getPostCountByCategory(HttpServletRequest request){
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<?> dataList = postService.getPostCounByCategory(pagination, filters);
			if (dataList != null) {
				result.setData(dataList);
				result.setMsg(AppConstants.MSG_SUCCESS);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				result.setData(null);
				result.setMsg(AppConstants.MSG_FAILED);
				result.setSuccess(false);
				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception e) {
			result.setData(null);
			result.setMsg(AppConstants.MSG_FAILED);
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
//	// Get Post By Companies
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
//	})
//	@GetMapping(AppConstants.POST_BY_COMPANIES)
//	public ResponseEntity<?> getPostByCompanies(HttpServletRequest request, @PathVariable(name = "company_id") Long company_id){
//		GenericResult result = new GenericResult();
//		try {
//			Pagination pagination = Pagination.formulatePaginationObject(request);
//			Map<String, String> filters = FilterManager.formulateFilterObject(request);
//			
//			List<?> dataList = postService.getPostByCompanies(pagination, filters, company_id);
//			if (dataList != null) {
//				result.setData(dataList);
//				result.setMsg(AppConstants.MSG_SUCCESS);
//				result.setSuccess(true);
//				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			}else {
//				result.setData(null);
//				result.setMsg(AppConstants.MSG_FAILED);
//				result.setSuccess(false);
//				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			}
//		} catch (Exception e) {
//			result.setData(null);
//			result.setMsg(AppConstants.MSG_FAILED);
//			result.setSuccess(false);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
	
	//get all post by particular companies
	@GetMapping(AppConstants.POST_BY_COMPANIES)
	public List<Post> getPostByCompanies(@PathVariable(name = "company_id") Long company_id) {
		return postService.getPostByCompanies(company_id);
	}
	
	// Get Post Count By Companies
	@GetMapping(AppConstants.POST_COUNT_BY_COMPANIES)
	public ResponseEntity<?> getPostCountByCompanies(HttpServletRequest request){
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<?> dataList = postService.getPostCountByCompanies(pagination, filters);
			if (dataList != null) {
				result.setData(dataList);
				result.setMsg(AppConstants.MSG_SUCCESS);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				result.setData(null);
				result.setMsg(AppConstants.MSG_FAILED);
				result.setSuccess(false);
				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception e) {
			result.setData(null);
			result.setMsg(AppConstants.MSG_FAILED);
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	// Get Deals Of The Day
	@GetMapping(AppConstants.DEALS_OF_THE_DAY)
	public ResponseEntity<?> getDealsOfTheDay(HttpServletRequest request){
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<?> dataList = postService.getDealsOfTheDay(pagination, filters);
			if (dataList != null) {
				result.setData(dataList);
				result.setMsg(AppConstants.MSG_SUCCESS);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				result.setData(null);
				result.setMsg(AppConstants.MSG_FAILED);
				result.setSuccess(false);
				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception e) {
			result.setData(null);
			result.setMsg(AppConstants.MSG_FAILED);
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	// Get Popular Post
	@GetMapping(AppConstants.POPULAR_POST)
	public ResponseEntity<?> getPopularPost(HttpServletRequest request){
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<?> dataList = postService.getPopularPost(pagination, filters);
			if (dataList != null) {
				result.setData(dataList);
				result.setMsg(AppConstants.MSG_SUCCESS);
				result.setSuccess(true);
				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			}else {
				result.setData(null);
				result.setMsg(AppConstants.MSG_FAILED);
				result.setSuccess(false);
				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception e) {
			result.setData(null);
			result.setMsg(AppConstants.MSG_FAILED);
			result.setSuccess(false);
			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}
