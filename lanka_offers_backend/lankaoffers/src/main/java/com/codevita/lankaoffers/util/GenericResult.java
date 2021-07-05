package com.codevita.lankaoffers.util;

/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
public class GenericResult {
	private boolean isSuccess;
	private String msg;
	private String status;
	private Object data;
	private Pagination pagination;
	
	//CONSTRUCTORS =============================================================
	public GenericResult(boolean isSuccess, String msg, String status, Object data) {
		super();
		this.isSuccess = isSuccess;
		this.msg = msg;
		this.status = status;
		this.data = data;
	}

	public GenericResult(boolean isSuccess, String msg, String status, Object data, Pagination pagination) {
		super();
		this.isSuccess = isSuccess;
		this.msg = msg;
		this.status = status;
		this.data = data;
		this.pagination = pagination;
	}

	public GenericResult(boolean isSuccess, String msg) {
		super();
		this.isSuccess = isSuccess;
		this.msg = msg;
	}

	public GenericResult() {
		super();
	}

	//GETTERS AND SETTERS =============================================================
	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
}

