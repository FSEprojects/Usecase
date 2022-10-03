package com.usecase.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.Service.AdminService;
import com.usecase.entity.Admin;
import com.usecase.repository.AdminRepository;

@CrossOrigin
@RestController
@RequestMapping("/admin")


public class UserController {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/signup")
	ResponseEntity createAdminAccount(@Valid @RequestBody Admin admin) {
		 Base64.Encoder encoder = Base64.getMimeEncoder();  
//		if (userRepo.existsByemail(admin.getEmail())) {
//			return new ResponseEntity("Email exist already!Please try with different mailid",HttpStatus.OK);
//		}
		if (adminRepository.existsByusername(admin.getUsername())) {
			return new ResponseEntity("UserName exist already!Please try with different username",HttpStatus.OK);
		}
		admin.setPassword(encoder.encodeToString(admin.getPassword().getBytes()));
		adminService.createAdmin(admin);

		return ResponseEntity.ok(admin);
	}
	
	@PostMapping("/login")
	ResponseEntity login(@Valid @RequestBody Admin admin) {
		Base64.Decoder decoder = Base64.getMimeDecoder();  
		if (adminRepository.existsByusername(admin.getUsername())) {
			Admin existingUser = adminRepository.getUser(admin.getUsername());
			String decodedPwd = new String (decoder.decode(existingUser.getPassword()));
			if (decodedPwd.equals(admin.getPassword())) {
				return new ResponseEntity(existingUser,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Password is wrong",HttpStatus.OK);
			}
		}
		return new ResponseEntity("UserName is wrong",HttpStatus.OK);
	}
	
	

}
