package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevita.lankaoffers.entity.Admin;
import com.codevita.lankaoffers.repository.AdminRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;

@Service
public class AdminService implements EntityManagementService {

	@Autowired
	private AdminRepo adminRepos;
	
	private static Logger logger = LogManager.getLogger(AdminRepo.class);
	
	private static String thisServiceForLogger = "Admin Service";
	
	@Override
	public List<?> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "getAll ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Admin> dataList = adminRepos.findAll();
			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, activityLogs);
			return dataList;
		}catch(Exception ex) {
			logger.error(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED+ " - "+ ex.getMessage());
//			return (List<?>) new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED , null);
			return null;
		}
	}

	@Override
	public GenericResult getOne(Long id) {
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getOne ";
		logger.info(thisMethodInfoLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		
		try {
			Optional<Admin> activityLog = adminRepos.findById(id);
			boolean isExist = activityLog != null;
			
			if(isExist) {
				logger.info(thisMethodInfoLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, activityLog);
			}else {
				logger.info(thisMethodInfoLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		} catch (Exception ex) {
			logger.error(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - "+ ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}

	}

	@Override
	public GenericResult add() {
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "add ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		return null;
	}

	@Override
	public GenericResult store(Object obj) {
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "store ";
		logger.info(thisMethodInfoLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Admin admins = (Admin)obj;
			admins = adminRepos.save(admins);
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, admins);
		}catch (Exception ex) {
			logger.error(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - "+ ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}
	}

	@Override
	public GenericResult edit(Long id) {
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "edit ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		return null;
	}

	@Override
	public GenericResult update(Object obj) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "update ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Admin admins = (Admin)obj;
			Optional<Admin> adminFromDb = adminRepos.findById(admins.getId());
			boolean isExist = adminFromDb != null;
			if(isExist) {
				admins = adminRepos.save(admins);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, admins);
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
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "delete ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Optional<Admin> admins = adminRepos.findById(id);
			boolean isExist = admins != null;
			if (isExist) {
				adminRepos.deleteById(id);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, admins);
			} else {
				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		}catch(Exception ex) {
			logger.error(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED , null);
		}
	}

}
