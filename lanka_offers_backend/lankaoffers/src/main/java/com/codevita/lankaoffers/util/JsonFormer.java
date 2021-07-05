package com.codevita.lankaoffers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
public class JsonFormer {
	public static String form(Object obj) {
	    String resultJson = "{}";
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//            mapper.setSerializationInclusion(Include.NON_NULL);
//            mapper.setSerializationInclusion(Include.NON_EMPTY);
            
            System.out.println("============================");
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();   
            resultJson = ow.writeValueAsString( obj );
        }
        catch ( Exception e ){
            e.printStackTrace();
        }
        return resultJson;
	}
	
	public static Object formObject(String json) {
		Object obj = null;
        try{
        	ObjectMapper mapper = new ObjectMapper();
        	obj = mapper.readValue(json, Object.class);
        }
        catch ( Exception e ){
            e.printStackTrace();
        }
        return obj;
	}
	
	public static Object formObjectClass(String json, Object object) {
		Object obj = null;
        try{
        	ObjectMapper mapper = new ObjectMapper();
        	obj = mapper.readValue(json, object.getClass());
        }
        catch ( Exception e ){
            e.printStackTrace();
        }
        return obj;
	}
}

