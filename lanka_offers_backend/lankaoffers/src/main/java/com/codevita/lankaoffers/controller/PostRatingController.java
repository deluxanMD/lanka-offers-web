package com.codevita.lankaoffers.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import com.codevita.lankaoffers.entity.PostRating;
import com.codevita.lankaoffers.service.PostRatingService;
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
public class PostRatingController {
	GenericResult validateResult;
	
	@Autowired
	PostRatingService postRatingService;
	
	// Get all
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@GetMapping(AppConstants.POST_RATING_URL)
	public ResponseEntity<?> getAll(HttpServletRequest request) {
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);

			List<PostRating> dataList = postRatingService.getAll(pagination, filters, null);

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
	@GetMapping(AppConstants.POST_RATING_BY_ID_URL)
	public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			result = postRatingService.getOne(id);

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
	@PostMapping(AppConstants.POST_RATING_URL)
	public ResponseEntity<Object> store(@RequestBody PostRating postRating) {
		GenericResult result = new GenericResult();
		try {
			// validation
			validateResult = Validator.validateNumber(postRating.getId(), "Id");
			if (!validateResult.isSuccess()) {
				result = validateResult;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}

			result = postRatingService.store(postRating);

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
		
	//Update Method
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@PutMapping(AppConstants.POST_RATING_BY_ID_URL)
	public ResponseEntity<?> update(@RequestBody PostRating postRating, @PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			// validation
			validateResult = Validator.validateText(postRating.getComment(), "Comments");
			if (!validateResult.isSuccess()) {
				result = validateResult;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}

			result = postRatingService.update(postRating);

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
	@DeleteMapping(AppConstants.POST_RATING_BY_ID_URL)
	public ResponseEntity<?> delete(@PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			result = postRatingService.delete(id);

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
}
