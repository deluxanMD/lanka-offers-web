package com.codevita.lankaoffers.service;

import java.util.List;
import java.util.Map;

import com.codevita.lankaoffers.util.GenericResult;
import com.codevita.lankaoffers.util.Pagination;

/**
 * 
 * @author ANOJAN KANESHATHAS
 *
 */
public interface EntityManagementService {
	
	public List<?> getAll(Pagination pagination, Map<String, String> filters, String keyword);
	public Object getOne(Long id);
	public GenericResult add();
	public GenericResult store(Object obj);
	public GenericResult edit(Long id);
	public GenericResult update(Object obj);
	public GenericResult delete(Long id);
}

