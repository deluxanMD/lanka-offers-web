package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codevita.lankaoffers.entity.Company;
import com.codevita.lankaoffers.entity.User;
import com.codevita.lankaoffers.repository.CompanyRepo;
import com.codevita.lankaoffers.repository.UserRepo;
import com.codevita.lankaoffers.util.AppConstants;
import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;
/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
@Service
public class CompanyService implements EntityManagementService{
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	private static Logger logger = LogManager.getLogger(CompanyRepo.class);
	
	private static String thisServiceForLogger = "Company Service ";

	@Override
	public List<Company> getAll(Pagination pagination, Map<String, String> filters, String keyword) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getAll ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Company> dataList = companyRepo.findAll();
			logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return dataList;
			
		} catch (Exception ex) {
			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return null;
		}
	}

	@Override
	public GenericResult getOne(Long id) {
		String thisMethodInfoForLogger = thisServiceForLogger + " -> " + "getOne ";
		logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			Optional<Company> company = companyRepo.findById(id);
			boolean isExist = company != null;
			if(isExist) {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, company);
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
			Company company = (Company)obj;
			
			//saving user object
			User user= company.getUser();
			boolean isExist = user != null;
			if(isExist) {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				userRepo.save(user);
				System.out.println(user);
			}else {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
			
			//assigning user id to service center
			company.setUser(user);
			
			//saving service center
			company = companyRepo.save(company);
			logger.info(thisMethodInfoForLogger + AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			
			return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, company);
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
			Company company = (Company)obj;
			Optional<Company> companyFromDb = companyRepo.findById(company.getId());
			boolean isExist = companyFromDb != null;
			if(isExist) {
				company = companyRepo.save(company);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, company);
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
			Optional<Company> company = companyRepo.findById(id);
			boolean isExist = company != null;
			if(isExist) {
				companyRepo.deleteById(id);
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
				return new GenericResult(true, AppConstants.MSG_SUCCESS, AppConstants.HTTP_RESULT_SUCCESS, company);
			}else {
				logger.info(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_DATA_NOT_FOUND);
				return new GenericResult(false, AppConstants.MSG_NOT_FOUND, AppConstants.HTTP_RESULT_FAILED, null);
			}
		} catch (Exception ex) {
			logger.error(thisMethodInfoForLogger, AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return new GenericResult(false, "Failed. Error - " + ex.getMessage(), AppConstants.HTTP_RESULT_FAILED, null);
		}
	}
	
	public List<Company> getCompanies(Pagination pagination, Map<String, String> filters){
		String thisMethodInfoLogger = thisServiceForLogger + " -> " + "getAll";
		logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_SERVICE_STARTED);
		try {
			List<Company> dataList = companyRepo.getBrands();
			logger.info(thisMethodInfoLogger,AppConstants.LOGGER_MSG_OPERATION_SUCCESSFUL);
			return dataList;
		} catch (Exception ex) {
			logger.info(thisMethodInfoLogger + AppConstants.LOGGER_MSG_OPERATION_FAILED + " - " + ex.getMessage());
			return null;	
		}
	}
}
