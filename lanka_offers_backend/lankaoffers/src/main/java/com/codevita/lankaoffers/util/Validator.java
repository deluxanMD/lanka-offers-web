package com.codevita.lankaoffers.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
public class Validator {
	public static GenericResult validateText(String value, String label) {
		GenericResult result = new GenericResult();

		if (value == null || "".equals(value)) {
			result.setMsg(label + " " + AppConstants.MSG_EMPTY);
			result.setSuccess(false);

		} else {
			result.setMsg("");
			result.setSuccess(true);
		}
		return result;
	}
	
	public static GenericResult validateNumber(Long value, String label) {
		GenericResult result = new GenericResult();

		if (value == null || "".equals(value)) {
			result.setMsg(label + " " + AppConstants.MSG_EMPTY);
			result.setSuccess(false);

		} else {
			result.setMsg("");
			result.setSuccess(true);
		}
		return result;
	}

	public static GenericResult validateEmail(String email, String label) {
		GenericResult result = new GenericResult();

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (email == null || "".equals(email)) {
			result.setMsg(label + " " + AppConstants.MSG_EMPTY);
			result.setSuccess(false);
			return result;
		}

		if (!matcher.matches()) {
			result.setMsg(label + " not valid");
			result.setSuccess(false);
			return result;
		}

		result.setMsg("");
		result.setSuccess(true);
		return result;

	}

	public static GenericResult validateText2(String value, String label) {
		GenericResult result = new GenericResult();

		if (value == null || "".equals(value)) {
			result.setMsg(label + " " + AppConstants.MSG_EMPTY);
			result.setSuccess(false);
		} else {
			result.setMsg("");
			result.setSuccess(true);
		}
		return result;
	}

	public static GenericResult validateDuration(String value, String label) {
		GenericResult result = new GenericResult();

		if (value == null || "".equals(value)) {
			result.setMsg(label + " " + AppConstants.MSG_EMPTY);
			result.setSuccess(false);
			return result;
		}

		if (Integer.parseInt(value) > 999) {
			result.setMsg(label + " cannot exit more tha 999 Minutes ");
			result.setSuccess(false);
			return result;
		}

		result.setMsg("");
		result.setSuccess(true);

		return result;
	}


	public static GenericResult validateTextForNumbers(String value, String label) {
		GenericResult result = new GenericResult();

		if (value != null && value.matches("\\d+")) {
			result.setMsg(label + " " + AppConstants.MSG_NOT_NUMBER);
			result.setSuccess(true);
		} else {
			result.setMsg("");
			result.setSuccess(false);
		}
		return result;
	}

	public static GenericResult validatePhoneNumbers(String value, String countryCode) {
		GenericResult result = new GenericResult();
		Integer digit = 0;
		String code = "";

		if (countryCode.equals(AppConstants.COUNTRY_SL)) {
			digit = 12;
			code = "+94";
		}

		String[] arr = value.split("");

		Boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				try {
					int num = Integer.parseInt(arr[i]);
				} catch (Exception e) {
					flag = false;
				}

			}
		}

		if (flag) {

			if (value.indexOf(code) == 0 && arr.length == digit) {
				result.setMsg(value + " is a " + countryCode + " number");
				result.setSuccess(true);
				// result.setCode(GenericResult.ST_FAIL);

			} else {
				result.setMsg(value + " " + "Not a srilanka number");
				result.setMsg(countryCode + " " + AppConstants.MSG_NOT_NUMBER);
				result.setSuccess(false);
				// result.setCode(GenericResult.ST_FAIL);

			}
		} else {
			result.setMsg("Phone Number must be in the form +9999999999");
			result.setSuccess(false);
		}
		return result;
	}

	public static GenericResult validatePhoneNumberWithCountry(String value, String countryCode) {
		GenericResult result = new GenericResult();

		String resutFromCheck;
		String code = value.substring(value.indexOf('(') + 1, value.indexOf(')'));
		Integer digit = value.length() - code.length();

//		
//		Map<String,String> countries = CountryDetails.getAllCountry();
//		
//		for (Map.Entry<String, String> entry : countries.entrySet()) {
//			if(entry.getValue().equals(code)) {
//				c
//			}else {
//				
//			}
//		}	
//		
		if (countryCode.equals(AppConstants.COUNTRY_SL)) {
			digit = 12;
			code = "+94";
		}

		String[] arr = value.split("");

		Boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				try {
					int num = Integer.parseInt(arr[i]);
				} catch (Exception e) {
					flag = false;
				}

			}
		}

		if (flag) {

			if (value.indexOf(code) == 0 && arr.length == digit) {
				result.setMsg(value + " is a " + countryCode + " number");
				result.setSuccess(true);
				// result.setCode(GenericResult.ST_FAIL);

			} else {
				result.setMsg(value + " " + "Not a srilanka number");
				result.setMsg(countryCode + " " + AppConstants.MSG_NOT_NUMBER);
				result.setSuccess(false);
				// result.setCode(GenericResult.ST_FAIL);

			}
		} else {
			result.setMsg("Phone Number must be in the form +9999999999");
			result.setSuccess(false);
		}
		return result;
	}

}
