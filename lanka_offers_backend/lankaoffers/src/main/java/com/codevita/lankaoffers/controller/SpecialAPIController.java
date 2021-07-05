package com.codevita.lankaoffers.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codevita.lankaoffers.entity.Post;
import com.codevita.lankaoffers.service.SpecialAPIService;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.FilterManager;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(AppConstants.BASE_URL)
public class SpecialAPIController {
	
	@Autowired
	SpecialAPIService specialAPIService;
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "authorization", value = "${controller.authorizationHeader.description}", paramType = "header")
	})
	@GetMapping("/home")
	public ResponseEntity<?> getHomeData(HttpServletRequest request) {
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<Post> dataList = specialAPIService.getLatestPosts(pagination, filters);
			JSONObject homeData = new JSONObject();
			homeData.append("latestPosts", dataList);

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

}
