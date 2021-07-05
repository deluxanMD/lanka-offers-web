package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevita.lankaoffers.entity.ActivityLog;
import com.codevita.lankaoffers.repository.ActivityLogRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;
/**
 * 
 * @author Harilojunan Nithiyananthan
 *
 */
@Service
public class ActivityLogService implements EntityManagementService {
	
	@Autowired
	private ActivityLogRepo activityLogRepo;
	
	private static Logger logger = LogManager.getLogger(ActivityLogRepo.class);
	
	private static String thisServiceForLogger = "ActivityLog Service";

	@Override
	public List<ActivityLog> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "getAll ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<ActivityLog> dataList = activityLogRepo.findAll();
			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, activityLogs);
			return dataList;
		}catch(Exception ex) {
			logger.error(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED+ " - "+ ex.getMessage());
//			return (List<?>) new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED , null);
			return null;
		}
	}

	public GenericResult getOne(Long id) {
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getOne ";
		logger.info(thisMethodInfoLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		
		try {
			Optional<ActivityLog> activityLog = activityLogRepo.findById(id);
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
			ActivityLog activityLog = (ActivityLog)obj;
			activityLog = activityLogRepo.save(activityLog);
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, activityLog);
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
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "update ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			ActivityLog activityLog = (ActivityLog)obj;
			Optional<ActivityLog> activityLogFromDb = activityLogRepo.findById(activityLog.getId());
			boolean isExist = activityLogFromDb != null;
			if (isExist) {
				activityLog = activityLogRepo.save(activityLog);
				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, activityLog);
			} else {
				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		}catch(Exception ex) {
			logger.error(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED , null);
		}
	}

	@Override
	public GenericResult delete(Long id) {
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "delete ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Optional<ActivityLog> activityLog = activityLogRepo.findById(id);
			boolean isExist = activityLog != null;
			if (isExist) {
				activityLogRepo.deleteById(id);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, activityLog);
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
