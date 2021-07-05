//package com.codevita.lankaoffers.service;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.codevita.lankaoffers.entity.Category;
//import com.codevita.lankaoffers.repository.CategoryRepo;
//import com.codevita.lankaoffers.util.AppConstants;
//import com.codevita.lankaoffers.util.GenericResult;
//import com.codevita.lankaoffers.util.Pagination;
///**
// * 
// * @author Anojan Kaneshathas
// *
// */
//@Service
//public class CategoryService implements EntityManagementService {
//
//	@Autowired
//	private CategoryRepo categoryRepo;
//	
//	private static Logger logger = LogManager.getLogger(CategoryRepo.class);
//	
//	private static String thisServiceForLogger = "Category Service ";
//	
//	@Override
//	public List<Category> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getAll ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		
//		try {
//			List<Category> dataList = categoryRepo.findAll();
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			//return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, dataList);
//			return dataList; 
//		}catch(Exception ex) {
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			//return (List<?>) new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
//			return null;
//		}
//	}
//
//	@Override
//	public GenericResult getOne(Long id) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getOne ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		
//		try {
//			Optional<Category> category = categoryRepo.findById(id);
//			boolean isExist = category != null;
//			
//			if (isExist) {
//				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, category);
//			} else {
//				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
//				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
//			}
//		}catch(Exception ex) {
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
//		}
//	}
//
//	@Override
//	public GenericResult add() {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "add ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		return null;
//	}
//	
//	@Override
//	public GenericResult store(Object obj) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "store ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		
//		try {
//			Category category = (Category)obj;
//			category = categoryRepo.save(category);
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, category);
//		}catch (Exception ex) {
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
//		}
//	}
//
//	@Override
//	public GenericResult edit(Long id) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "edit ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		return null;
//	}
//
//	@Override
//	public GenericResult update(Object obj) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "update ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		
//		try {
//			Category category = (Category)obj;
//			Optional<Category> categoryFromDb = categoryRepo.findById(category.getId());
//			boolean isExist = categoryFromDb != null;
//			
//			if (isExist) {
//				category = categoryRepo.save(category);
//				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, category);
//			} else {
//				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
//				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
//			}
//		}catch(Exception ex) {
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
//		}
//	}
//
//	@Override
//	public GenericResult delete(Long id) {
//		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "delete ";
//		logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_SERVICE_STARTED);
//		
//		try {
//			Optional<Category> category = categoryRepo.findById(id);
//			boolean isExist = category != null;
//			
//			if (isExist) {
//				categoryRepo.deleteById(id);
//				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, category);
//			} else {
//				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
//				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
//			}
//		}catch(Exception ex) {
//			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
//			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
//		}
//	}
//	
//	public boolean isCategoryAlreadyExist(String name) {
//		return categoryRepo.existsByName(name);
//	}
//	
//}
