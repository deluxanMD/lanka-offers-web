package com.codevita.lankaoffers.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
public class FilterManager {
	public static final String FILTERS_PARAMETER = "filters";
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> formulateFilterObject(HttpServletRequest request)
	{
		Map<String, String> filters = new HashMap<>();
		
		if(request.getParameter(FilterManager.FILTERS_PARAMETER) != null)
		{
			System.out.println("FILTERS_PARAMETER"+FilterManager.FILTERS_PARAMETER);
			try
			{

				filters = (Map<String, String>)JsonFormer.formObject(request.getParameter(FilterManager.FILTERS_PARAMETER).trim());
                System.out.println("Filterssssssssss: "+filters);
				if(filters.get("search") == null)
					filters.put("search", "%%");
				
				else
					filters.put("search", "" + filters.get("search") + "");

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return filters;
	}
	
}
