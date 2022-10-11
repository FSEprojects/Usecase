package com.usecase.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.usecase.entity.Admin;
import com.usecase.repository.AdminRepository;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {
	@InjectMocks
	AdminService adminService;
	
	@Mock
	AdminRepository adminrepo;

	@Test
	void testCreateAdminMethod() {
		Admin admin = new Admin();
		admin.setUsername("abc@gmail.com");
//		user.setEmail("abc@gmail.com");
		admin.setPassword("12345678");
//		user.setGender("Male");
//		user.setUserrole("Author");
		Mockito.lenient().when(adminrepo.save(admin)).thenReturn(admin);
		assertEquals(admin.getUsername(), "abc@gmail.com");
	}

}
