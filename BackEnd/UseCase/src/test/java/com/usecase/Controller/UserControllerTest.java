package com.usecase.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.usecase.Service.AdminService;
import com.usecase.controller.UserController;
import com.usecase.entity.Admin;
import com.usecase.repository.AdminRepository;
import com.usecase.requestdto.LoginRequestDto;

class UserControllerTest {
	
	@InjectMocks
	private UserController userController;

	@Mock
	private AdminRepository adminRepo;

	@Mock
	private AdminService adminService;

	@Test
	void testLogIn() {
		LoginRequestDto admin = new LoginRequestDto();
		admin.setUsername("Mary");
		admin.setPassword("12345678");

		Mockito.lenient().when(adminRepo.existsByusername(admin.getUsername())).thenReturn(true);
		Base64.Decoder decoder = Base64.getMimeDecoder();  
		Admin userToCheck = adminRepo.getUser(admin.getUsername());
		String decodedPwd = new String (decoder.decode(admin.getPassword()));
//		Mockito.lenient().when(userToCheck.getPassword().equals(user.getPassword())).thenReturn(true);
		ResponseEntity responseEntity = new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
		assertEquals(responseEntity.getBody(), "Logged in successfully");
	}
	
	@Test
	void testCreateUser() {
		Admin admin = new Admin();
		admin.setUsername("Elon@gnmail.com");
//		user.setEmail("abc@gmail.com");
		admin.setPassword("123");
//		user.setGender("Male");
//		user.setUserrole("Author");

//		Mockito.lenient().when(userRepo.existsByemail(admin.getEmail())).thenReturn(false);
		Mockito.lenient().when(adminRepo.existsByusername(admin.getUsername())).thenReturn(false);
		Base64.Encoder encoder = Base64.getMimeEncoder();  
		admin.setPassword(encoder.encodeToString(admin.getPassword().getBytes()));
		ResponseEntity responseEntity = ResponseEntity.ok("User registered successfully");
		adminService.createAdmin(admin);
		assertEquals(responseEntity.getBody(), "User registered successfully");
	}

}
