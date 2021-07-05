package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codevita.lankaoffers.entity.Company;
import com.codevita.lankaoffers.entity.Images;
import com.codevita.lankaoffers.entity.Post;
import com.codevita.lankaoffers.repository.PostRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;
/**
 * 
 * @author Harilojunan Nithiyananthan
 *
 */
@Service
public class PostService implements EntityManagementService {
	
	@Autowired
	private PostRepo postRepo;
	
	private static Logger logger = LogManager.getLogger(PostRepo.class);
	
	private static String thisServiceForLogger = "Post Service ";

	@Override
	public List<Post> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getAll ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Post> dataList = postRepo.findAll();
			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, posts);
			return dataList;
		} catch (Exception ex) {
			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return (List<?>) new GenericResult(false, "Failer Error - "+ ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
			return null;
		}
	}

	@Override
	public GenericResult getOne(Long id) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getOne ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Optional<Post> post = postRepo.findById(id);
			boolean isExist = post != null;
			if(isExist) {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, post);
			}else {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		} catch (Exception ex) {
			logger.error(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}	
	}

	@Override
	public GenericResult add() {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "add ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		return null;
	}

	@Override
	public GenericResult store(Object obj) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "store ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Post post = (Post)obj;
			
			post = postRepo.save(post);
			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, post);
		} catch (Exception ex) {
			logger.error(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}
	}

	@Override
	public GenericResult edit(Long id) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "edit ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		return null;
	}

	@Override
	public GenericResult update(Object obj) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "update ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Post post = (Post)obj;
			Optional<Post> postFromDb = postRepo.findById(post.getId());
			boolean isExist = postFromDb != null;
			if(isExist) {
				post = postRepo.save(post);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, post);
			}else {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		} catch (Exception ex) {
			logger.error(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}
	}

	@Override
	public GenericResult delete(Long id) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "delete ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Optional<Post> post = postRepo.findById(id);
			boolean isExist = post != null;
			if(isExist) {
				postRepo.deleteById(id);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, post);
			}else {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		} catch (Exception ex) {
			logger.error(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}
	}
	
	public List<Post> getLatestPosts(Pagination pagination, Map<String, String> filters){
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Post> dataList = postRepo.getLatestPosts();
			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return dataList;
		} catch (Exception ex) {
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return null;	
		}
	}
	
	public List<Post> getPostCounByCategory(Pagination pagination, Map<String, String> filters){
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Post> dataList = postRepo.getPostCountByCategory();
			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return dataList;
		} catch (Exception ex) {
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return null;	
		}
	}
	
	public List<Post> getPostCountByCompanies(Pagination pagination, Map<String, String> filters){
	String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
	logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
	try {
		List<Post> dataList = postRepo.getPostCountByCompany();
		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
		return dataList;
	} catch (Exception ex) {
		logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
		return null;	
	}
}
	
//	public List<Post> getPostByCategory(Pagination pagination, Map<String, String> filters, long postcategory_id){
//		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
//		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		try {
//			List<Post> dataList = postRepo.getPostByCategory(postcategory_id);
//			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return dataList;
//		} catch (Exception ex) {
//			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return null;	
//		}
//	}
	
	//get all booking histories by particular service Center id
	public List<Post> getPostByCategory(Long postcategory_id) {
		logger.info("Post Service started -> getPostByCategory");
		return postRepo.getPostByCategory(postcategory_id);
	}
	
//	public List<Post> getPostByCompanies(Pagination pagination, Map<String, String> filters, long company_id){
//		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
//		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		try {
//			List<Post> dataList = postRepo.getPostByCompany(company_id);
//			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return dataList;
//		} catch (Exception ex) {
//			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return null;	
//		}
//	}
	
	//get all booking histories by particular service Center id
	public List<Post> getPostByCompanies(Long company_id) {
		logger.info("Post Service started -> getPostByCompany");
		return postRepo.getPostByCompany(company_id);
	}
	
	public List<Post> getDealsOfTheDay(Pagination pagination, Map<String, String> filters){
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Post> dataList = postRepo.getDealsOfTheDay();
			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return dataList;
		} catch (Exception ex) {
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return null;	
		}
	}
	
	public List<Post> getPopularPost(Pagination pagination, Map<String, String> filters){
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Post> dataList = postRepo.getPopularPost();
			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return dataList;
		} catch (Exception ex) {
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return null;	
		}
	}
	
}
