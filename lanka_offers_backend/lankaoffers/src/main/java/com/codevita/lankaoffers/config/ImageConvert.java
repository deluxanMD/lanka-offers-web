package com.codevita.lankaoffers.config;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codevita.lankaoffers.util.AppConstants;

public class ImageConvert {
	
public static String imageSave(String base64String) {
		
	//Image Converter Class
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		final String baseUri = "/image/";
			try {
				String[] strings = base64String.split(",");
		        String extension;
		        switch (strings[0]) {//check image's extension
		            case "data:image/jpeg;base64":
		                extension = ".jpeg";
		                break;
		            case "data:image/png;base64":
		                extension = ".png";
		                break;
		            default://should write cases for more images types
		                extension = ".jpg";
		                break;
		        }
		        //convert base64 string to binary data
		        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
		        String imageName =  UUID.randomUUID().toString().replaceAll("-", "") + extension;
		        
		        String path = AppConstants.UPLOAD_PATH + imageName;
		        File file = new File(path);
		        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
		            outputStream.write(data);
		       
		            return baseUrl + baseUri + imageName ;
		        } catch (Exception e) {
		        	return e.toString();
		        }
		     
		    } catch (Exception e) {
		    	return e.toString();
		    }
	        
	}

}
