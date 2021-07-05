package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevita.lankaoffers.entity.BlockedCompany;
import com.codevita.lankaoffers.repository.BlockedCompanyRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;
/**
 * 
 * @author Harilojunan Nithiyananthan
 *
 */
@Service
public class BlockedCompanyService implements EntityManagementService {
	
	@Autowired
	private BlockedCompanyRepo blockedCompanyRepo;
	
	private static Logger logger = LogManager.getLogger(BlockedCompanyRepo.class);
	
	private static String thisServiceForLogger = "BlockedCompanyService";

	@Override
	public List<BlockedCompany> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
		String thisMethodInfoForLogger = thisServiceForLogger + " - > " + "getAll ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<BlockedCompany> dataList = blockedCompanyRepo.findAll();
			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, blockedCompanies);
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
			Optional<BlockedCompany> blockedCompany = blockedCompanyRepo.findById(id);
			boolean isExist = blockedCompany != null;
			if(isExist) {
				logger.info(thisMethodInfoLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, blockedCompany);
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
			BlockedCompany blockedCompany = (BlockedCompany)obj;
			blockedCompany = blockedCompanyRepo.save(blockedCompany);
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, blockedCompany);
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
			BlockedCompany blockedCompany = (BlockedCompany)obj;
			Optional<BlockedCompany> blockedCompanyFromDb = blockedCompanyRepo.findById(blockedCompany.getId());
			boolean isExist = blockedCompanyFromDb != null;
			if (isExist) {
				blockedCompany = blockedCompanyRepo.save(blockedCompany);
				logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, blockedCompany);
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
			Optional<BlockedCompany> blockedCompany = blockedCompanyRepo.findById(id);
			boolean isExist = blockedCompany != null;
			if (isExist) {
				blockedCompanyRepo.deleteById(id);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, blockedCompany);
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
