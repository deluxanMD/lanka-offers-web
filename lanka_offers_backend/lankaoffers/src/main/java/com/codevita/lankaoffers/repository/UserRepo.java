package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

//	User findUserById(Long id);
	
	boolean existsByContactNo(String contactNo);

	boolean existsByEmail(String email);

	User findByResetToken(String resetToken);
	
	User findByEmail(String email);
	
	User findByContactNo(String contactNo);
	
	

}
