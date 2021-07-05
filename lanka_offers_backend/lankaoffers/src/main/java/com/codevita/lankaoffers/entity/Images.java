package com.codevita.lankaoffers.entity;

public class Images {
	
	private String picName;
	
	private String type;
	
	private String uri;
	
	private long size;
	
	//CONSTRUCTORS =============================================================================
	
	public Images() {
		super();
	}

	public Images(String picName, String type, String uri, long size) {
		
		super();
		this.picName = picName;
		this.type = type;
		this.uri = uri;
		this.setSize(size);
	}
	
	//GETTERS AND SETTERS============================================================

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}


}
