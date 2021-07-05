package com.codevita.lankaoffers.util;

public class BasicResponse<T> extends ApiResponse {

	public BasicResponse(RestApiResponseStatus restApiResponseStatus , String message) {
		super(restApiResponseStatus);
		super.setMessage(message);
	}
	
	public BasicResponse() {
		super(RestApiResponseStatus.OK);
	}
	
	public BasicResponse(T responseBody, RestApiResponseStatus restApiResponseStatus, String message) {
		super(restApiResponseStatus);
		super.setMessage(message);
	}

}
