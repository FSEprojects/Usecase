package com.usecase.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.entity.Admin;
import com.usecase.repository.AdminRepository;

@Service

public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;

	public void createAdmin(@Valid Admin admin) {
		adminRepository.save(admin);
		
		
	}

}
