package com.codevita.lankaoffers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codevita.lankaoffers.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {
	
//	@Query(value ="")  
//	List<Company> getPopularCompanies();
	
	//Search Query
	@Query("SELECT c FROM Company c WHERE "
			+ " LOWER(CONCAT(c.companyName, c.regNo, c.email, c.address, c.contact1, c.contact2,"
			+ " c.location, c.category, c.ownerNIC, c.ownerAddress, c.status))"
			+ " LIKE %?1%")
	public List<Company> searchIgnoreCase(String keyword);
	
	@Query(value = "SELECT * FROM companies ORDER BY created_at DESC" , nativeQuery = true) 
	public List<Company> getBrands();


}
