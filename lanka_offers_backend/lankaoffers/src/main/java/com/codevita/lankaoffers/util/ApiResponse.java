package com.codevita.lankaoffers.util;

public class ApiResponse {
	
	public static final ApiResponse OK = new ApiResponse(RestApiResponseStatus.OK);

	public ApiResponse(RestApiResponseStatus restApiResponseStatus) {
		this.status = restApiResponseStatus.getStatus();
		this.statusCode = restApiResponseStatus.getCode();
	}

	private String status;

	private Integer statusCode;

	private String serviceName;

	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
