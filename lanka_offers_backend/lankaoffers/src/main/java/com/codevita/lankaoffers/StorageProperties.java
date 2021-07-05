package com.codevita.lankaoffers;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class StorageProperties {
	
	private String upLoadDir;

	public String getUpLoadDir() {
		return upLoadDir;
	}

	public void setUpLoadDir(String upLoadDir) {
		this.upLoadDir = upLoadDir;
	}


}
