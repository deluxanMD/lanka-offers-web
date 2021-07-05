package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevita.lankaoffers.entity.CompanyCardInfo;
import com.codevita.lankaoffers.repository.CompanyCardInfoRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;
/**
 * 
 * @author Harilojunan Nithiyananthan
 *
 */
@Service
public class CompanyCardInfoService implements EntityManagementService {
	
	@Autowired
	private CompanyCardInfoRepo companyCardInfoRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyCardInfoRepo.class);
	
	private static String thisServiceForLogger = "CompanyCardInfo Service ";

	@Override
	public List<CompanyCardInfo> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getAll ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<CompanyCardInfo> dataList = companyCardInfoRepo.findAll();
			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
//			return (List<?>) new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companyCardInfos);
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
			Optional<CompanyCardInfo> companyCardInfo = companyCardInfoRepo.findById(id);
			boolean isExist = companyCardInfo != null;
			if(isExist) {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companyCardInfo);
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
			CompanyCardInfo companyCardInfo = (CompanyCardInfo)obj;
			companyCardInfo = companyCardInfoRepo.save(companyCardInfo);
			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companyCardInfo);
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
			CompanyCardInfo companyCardInfo = (CompanyCardInfo)obj;
			Optional<CompanyCardInfo> companyCardInfoFromDb = companyCardInfoRepo.findById(companyCardInfo.getId());
			boolean isExist = companyCardInfoFromDb != null;
			if(isExist) {
				companyCardInfo = companyCardInfoRepo.save(companyCardInfo);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companyCardInfo);
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
			Optional<CompanyCardInfo> companyCardInfo = companyCardInfoRepo.findById(id);
			boolean isExist = companyCardInfo != null;
			if(isExist) {
				companyCardInfoRepo.deleteById(id);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, companyCardInfo);
			}else {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		} catch (Exception ex) {
			logger.error(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}
	}
	
}
