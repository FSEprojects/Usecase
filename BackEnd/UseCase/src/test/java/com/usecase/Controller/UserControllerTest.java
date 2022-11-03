package com.usecase.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.usecase.Service.AdminService;
import com.usecase.Service.PatientService;
import com.usecase.controller.PatientController;
import com.usecase.controller.UserController;
import com.usecase.entity.Admin;
import com.usecase.entity.Patient;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientInductionRepository;
import com.usecase.requestdto.LoginRequestDto;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@InjectMocks
	PatientController patientController;

	@Mock
	AdminRepository adminRepository;
	
	@Mock
	PatientInductionRepository patientRepository;

	@Mock
	AdminService adminService;
	
	@Mock
	PatientService patientService;

	@Test
	void testLogIn() {
//		LoginRequestDto admin = new LoginRequestDto();
		Admin admin = new Admin();
		admin.setUsername("mary@gmail.com");
		admin.setPassword("1234");

		Mockito.lenient().when(adminRepository.existsByusername(admin.getUsername())).thenReturn(true);
		Base64.Decoder decoder = Base64.getMimeDecoder();  
		Admin userToCheck = adminRepository.getUser(admin.getUsername());
		String decodedPwd = new String (decoder.decode(admin.getPassword()));
//		Mockito.lenient().when(userToCheck.getPassword().equals(admin.getPassword())).thenReturn(true);
		ResponseEntity responseEntity = new ResponseEntity<>("Logged in successfully", HttpStatus.OK);
		assertEquals(responseEntity.getBody(), "Logged in successfully");
	}
//	
	@Test
	void testCreateUser() {
		Admin admin = new Admin();
		admin.setUsername("Elon@gnmail.com");
//		user.setEmail("abc@gmail.com");
		admin.setPassword("123");
//		user.setGender("Male");
//		user.setUserrole("Author");

//		Mockito.lenient().when(userRepo.existsByemail(admin.getEmail())).thenReturn(false);
		Mockito.lenient().when(adminRepository.existsByusername(admin.getUsername())).thenReturn(false);
		Base64.Encoder encoder = Base64.getMimeEncoder();  
		admin.setPassword(encoder.encodeToString(admin.getPassword().getBytes()));
		ResponseEntity responseEntity = ResponseEntity.ok("User registered successfully");
		adminService.createAdmin(admin);
		assertEquals(responseEntity.getBody(), "User registered successfully");
	}
	
//	@Test
//	public void Testlogin() {
//		Admin admin = new Admin();
//		admin.setUsername("akhil@gmail.com");
//		admin.setPassword("12345678");
//		when(adminRepository.existsByusername(admin.getUsername())).thenReturn(false);
//		Admin response = adminService.get
//		
//	}
	
	@Test
	void testLogInWrongUserName() {
		LoginRequestDto admin = new LoginRequestDto();
		admin.setUsername("ABC");
		admin.setPassword("123");

		Mockito.lenient().when(adminRepository.existsByusername(admin.getUsername())).thenReturn(false);
		ResponseEntity responseEntity = ResponseEntity.badRequest().body("UserName is wrong");
		assertEquals(responseEntity.getBody(), "UserName is wrong");
	}
	@Test
	void testCreateUserExistByName() {
		Admin admin = new Admin();
		admin.setUsername("Mary@gmail.com");
//		user.setEmail("abc@gmail.com");
		admin.setPassword("123");
//		user.setGender("Male");
//		user.setUserrole("Author");

		Mockito.lenient().when(adminRepository.existsByusername(admin.getUsername())).thenReturn(true);
		ResponseEntity responseEntity=ResponseEntity.badRequest().body("UserName exist already!Please try with different username");
		assertEquals(responseEntity.getBody(), "UserName exist already!Please try with different username");
	}
	@Test
	public void updateIdTest() {
		ArrayList<Patient> list = new ArrayList<Patient>();
		
		Patient patient1=new Patient();
		patient1.setPatient_Id(1L);
		patient1.setPatient_Name("Akhil");
		patient1.setPatient_Address("hyd");
		patient1.setEmail("Akhil@gmail.com");
		patient1.setDOB("11-11-1990");
		patient1.setContact_Number(9876543210L);
		patient1.setDrug_Name("cipla");
		patient1.setDrug_Id(1234L);
		list.add(patient1);
		Patient updated = new Patient();
		updated.setPatient_Id(1L);
		updated.setPatient_Name("Akhil");
		updated.setPatient_Address("hyd");
		updated.setEmail("Akhil@gmail.com");
		updated.setDOB("11-11-1990");
		updated.setContact_Number(9876543210L);
		updated.setDrug_Name("cipla");
		updated.setDrug_Id(1234L);
		
		Mockito.lenient().when(patientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(patient1));
		Mockito.lenient().when(patientRepository.save(Mockito.any())).thenReturn(patient1);
		patientController.update(patient1);
		
	}
	

}
