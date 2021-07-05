package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevita.lankaoffers.entity.Post;
import com.codevita.lankaoffers.repository.PostRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.Pagination;

@Service
public class SpecialAPIService {
	
//	@Autowired
//	private CompanyRepo companyRepo;
	
	@Autowired
	private PostRepo postRepo;
	
//	private static Logger logger = LogManager.getLogger(CompanyRepo.class);
	private static Logger logger1 = LogManager.getLogger(PostRepo.class);
	
	
	private static String thisServiceForLogger = "SpecialAPI Service ";
	
	public List<Post> getLatestPosts(Pagination pagination, Map<String, String> filters) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getAll ";
		logger1.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Post> dataList = postRepo.getLatestPosts();
			logger1.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companies);
			return dataList;
			
		} catch (Exception ex) {
			logger1.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return (List<?>) new GenericResult(false, "Failer Error - "+ ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
			return null;
		}
	}
	
//	public List<Company> getPopularPosts(Pagination pagination, Map<String, String> filters) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getAll ";
//		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		try {
//			List<Company> dataList = companyRepo.getPopularCompanies(); 
//			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
////			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companies);
//			return dataList;
//			
//		} catch (Exception ex) {
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
////			return (List<?>) new GenericResult(false, "Failer Error - "+ ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
//			return null;
//		}
//	}

}
