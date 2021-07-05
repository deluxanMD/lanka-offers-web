//package com.codevita.lankaoffers.controller;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import com.codevita.lankaoffers.config.JwtTokenUtil;
//import com.codevita.lankaoffers.entity.Category;
//import com.codevita.lankaoffers.repository.CategoryRepo;
//import com.codevita.lankaoffers.service.CategoryService;
//import com.codevita.lankaoffers.util.AppConstants;
//import com.codevita.lankaoffers.util.FilterManager;
//import com.codevita.lankaoffers.util.GenericResult;
//import com.codevita.lankaoffers.util.Pagination;
//import com.codevita.lankaoffers.util.Validator;
//
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//
///**
// * 
// * @author ANOJAN KANESHATHAS
// *
// */
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping(AppConstants.BASE_URL)
//public class CategoryController {
//	GenericResult validateResult;
//
//	@Autowired
//	CategoryRepo categoryRepo;
//	
//	@Autowired
//	CategoryService categoryService;
//	
//	// Get all
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
//	})
//	@GetMapping(AppConstants.CATEGORY_URL)
//	public ResponseEntity<?> getAll(HttpServletRequest request) {
//		GenericResult result = new GenericResult();
//		try {
//			Pagination pagination = Pagination.formulatePaginationObject(request);
//			Map<String, String> filters = FilterManager.formulateFilterObject(request);
//
//			List<Category> dataList = categoryService.getAll(pagination, filters, null);
//
//			if (dataList != null) {
//				result.setData(dataList);
//				result.setMsg(AppConstants.MSG_SUCCESS);
//				result.setSuccess(true);
//				result.setStatus(AppConstants.HTTP_RESULT_SUCCESS);
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			} else {
//				result.setData(null);
//				result.setMsg(AppConstants.MSG_FAILED);
//				result.setSuccess(true);
//				result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			}
//
//		} catch (Exception e) {
//			result.setData(null);
//			result.setMsg(AppConstants.MSG_FAILED);
//			result.setSuccess(true);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//
//	// Get one
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
//	})
//	@GetMapping(AppConstants.CATEGORY_BY_ID_URL)
//	public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable long id) {
//		GenericResult result = new GenericResult();
//		try {
//			result = categoryService.getOne(id);
//
//			if (result.isSuccess()) {
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			}
//
//		} catch (Exception e) {
//			result = new GenericResult();
//			result.setData(null);
//			result.setMsg(e.getMessage());
//			result.setSuccess(false);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//	
//
//	@PostMapping(AppConstants.CATEGORY_URL)
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
//	})
//	public ResponseEntity<Object> store(@RequestBody Category category) {
//		GenericResult result = new GenericResult();
//		try {
//			// validation
//			validateResult = Validator.validateText(category.getName(), "Name");
//			if (!validateResult.isSuccess()) {
//				result = validateResult;
//				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
//			}
//			System.out.println("`````````````````````````````");
//			System.out.println(category.getName());
//			System.out.println("``````````````````````````");
//			result = categoryService.store(category);
//
//			if (!result.isSuccess()) {
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			} else {
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			result = new GenericResult();
//			result.setData(null);
//			result.setMsg(e.getMessage());
//			result.setSuccess(false);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//	
//	@PutMapping(AppConstants.CATEGORY_BY_ID_URL)
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
//	})
//	public ResponseEntity<Object> update(@RequestBody Category category, @PathVariable long id) {
//		GenericResult result = new GenericResult();
//		try {
//			// validation
//			validateResult = Validator.validateText(category.getName(), "Name");
//			if (!validateResult.isSuccess()) {
//				result = validateResult;
//				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
//			}
//
//			result = categoryService.update(category);
//
//			if (!result.isSuccess()) {
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			} else {
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			result = new GenericResult();
//			result.setData(null);
//			result.setMsg(e.getMessage());
//			result.setSuccess(false);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//	
//	@DeleteMapping(AppConstants.CATEGORY_BY_ID_URL)
//	public ResponseEntity<?> delete(@PathVariable long id) {
//		GenericResult result = new GenericResult();
//		try {
//			result = categoryService.delete(id);
//
//			if (!result.isSuccess()) {
//				return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//			} else {
//				return new ResponseEntity<>(result, HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			result = new GenericResult();
//			result.setData(null);
//			result.setMsg(e.getMessage());
//			result.setSuccess(false);
//			result.setStatus(AppConstants.HTTP_RESULT_FAILED);
//			return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//		}
//	}
//}
