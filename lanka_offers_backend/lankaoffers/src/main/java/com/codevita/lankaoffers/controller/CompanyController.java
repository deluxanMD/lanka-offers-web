package com.codevita.lankaoffers.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.codevita.lankaoffers.config.ImageConvert;
import com.codevita.lankaoffers.config.RandomStringGenerator;
import com.codevita.lankaoffers.entity.Company;
import com.codevita.lankaoffers.entity.Images;
import com.codevita.lankaoffers.service.CompanyService;
import com.codevita.lankaoffers.service.ImageStorageService;
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
public class CompanyController {
	GenericResult validateResult;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	ImageStorageService imageStorageServices;
	
	// Get all
	@GetMapping(AppConstants.COMPANY_URL)
	public ResponseEntity<?> getAll(HttpServletRequest request) {
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);

			List<Company> dataList = companyService.getAll(pagination, filters, null);

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
	@GetMapping(AppConstants.COMPANY_BY_ID_URL)
	public ResponseEntity<?> getOne(HttpServletRequest request, @PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			result = companyService.getOne(id);

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
	@PostMapping(AppConstants.UPLOAD_COMPANY_LOGO)
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
	@PostMapping(AppConstants.COMPANY_SIGN_UP)
	public ResponseEntity<Object> store(@RequestBody Company company, @RequestParam("image") MultipartFile image) {
		GenericResult result = new GenericResult();
		try {
			byte[] bytes = image.getBytes();
			Path path = Paths.get(AppConstants.UPLOAD_PATH + RandomStringGenerator.getRandomString(12) + "_" + image.getOriginalFilename());
			Files.write(path, bytes);
	
			// validation
			validateResult = Validator.validateText(company.getCompanyName(), "Company Name");
			if (!validateResult.isSuccess()) {
				result = validateResult;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}
			
			//saving company
			String encryptedPw = bCryptPasswordEncoder.encode(company.getUser().getPassword());
			company.getUser().setPassword(encryptedPw);
			company.getUser().setRole("COMPANY");
			company.setLogo(path.toString());
			result = companyService.store(company);

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
	@PutMapping(AppConstants.COMPANY_BY_ID_URL)
	public ResponseEntity<?> update(HttpServletRequest request, @RequestBody Company company, @PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			final String baseUri = "/image/";
			String imagePath = baseUrl + baseUri + "userdefault.jpeg";
			if(company.getLogo() == null || company.getLogo().isEmpty()  ) {
				
				company.setLogo(imagePath.toString());
			}

			if(request.getParameter("image") != null  && !request.getParameter("image").isEmpty()  ) {
				
				imagePath = ImageConvert.imageSave(request.getParameter("image"));
			}
			
			// validation
			validateResult = Validator.validateText(company.getEmail(), "Email");
			if (!validateResult.isSuccess()) {
				result = validateResult;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}
			
			if(request.getParameter("is_default") != null && request.getParameter("is_default").equals("0")) {
				System.out.println(request.getParameter("is_default"));
				company.setLogo(imagePath.toString());
			}

			result = companyService.update(company);

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
	@DeleteMapping(AppConstants.COMPANY_BY_ID_URL)
	public ResponseEntity<?> delete(@PathVariable long id) {
		GenericResult result = new GenericResult();
		try {
			result = companyService.delete(id);

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
	
	//Get Companies
	@GetMapping(AppConstants.COMPANY_CREATED_DATEWISE)
	public ResponseEntity<?> getCompanies(HttpServletRequest request){
		GenericResult result = new GenericResult();
		try {
			Pagination pagination = Pagination.formulatePaginationObject(request);
			Map<String, String> filters = FilterManager.formulateFilterObject(request);
			
			List<?> dataList = companyService.getCompanies(pagination, filters);
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
