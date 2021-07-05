package com.codevita.lankaoffers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.codevita.lankaoffers.entity.Admin;
import com.codevita.lankaoffers.entity.User;
import com.codevita.lankaoffers.repository.AdminRepo;
import com.codevita.lankaoffers.repository.UserRepo;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Autowired
    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
    	User user = new User();
    	user.setContactNo("0212224471"); 
    	user.setName("Admin");
    	user.setRole("Admin");
    	user.setEmail("admin@codevita.lk");
    	user.setPassword(bCryptPasswordEncoder.encode("admin"));
//		user = userRepo.save(user);
    	
    	Admin admin = new Admin();
    	admin.setUser(user);
// 		adminRepo.save(admin);
    }

}
