package com.usecase.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.usecase.controller.PatientController;
import com.usecase.entity.Patient;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientInductionRepository;

//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
	
	@InjectMocks
	PatientService patientService;
	
	@Mock
	PatientInductionRepository patientRepository;

	
	
//	@Mock
//	PatientController controller;
	
	
	Patient patient;
	
//	@Before
//	public void setUp() {
//		patientInduction = new PatientInduction((long) 1,"akhil","hyd","11-11-2001","akhil@gmail.com",(long)987654321,(long)24425342,"dolo");
//	}

//	@Test
//	void testgetpatientId() {
//		String Patient_Id = new String("1");
////		Optional<PatientInduction> patientList = Optional.of(new PatientInduction());
//		List<PatientInduction> patientList = new ArrayList<>();
////		ArrayList<PatientInduction> list = new ArrayList<>(Arrays.asList(sos1.getValue());
//		PatientInduction patient = new PatientInduction();
//		patient.setDOB("11-11-1911");
//		patient.setEmail("akhil@gmail.com");
//		patient.setDrug_Id((long) 1);
//		patient.setPatient_Name("John");
//		patient.setDrug_Name("John");
//		patient.setPatient_Id((long)1);
//		patient.setContact_Number((long)1);
////		book.setActive("true");
//		patientList.add(patient);
//		Mockito.lenient().when(patientRepository.getPatientById(Patient_Id)).thenReturn((PatientInduction) patientList);
//		assertEquals(patientList.size(), patientList.size());
//	}
	@Test
	public void testgetpatientbyId() {
		String patient_Id = "2";
		when(patientRepository.getPatientById(patient_Id)).thenReturn(patient);
		Patient response = patientService.getPatientId(patient_Id);
		assertEquals(patient, response);
		
	}
	
	@Test
	public void updateTest() {
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
		patientService.update(patient1);
		
	}
//	@Test
//	public void testgetallpatients() {
//		PatientInduction patient = new PatientInduction();
//		patient.setDOB("11-11-1911");
//		patient.setEmail("akhil@gmail.com");
//		patient.setDrug_Id((long) 1);
//		patient.setPatient_Name("John");
//		patient.setDrug_Name("John");
//		patient.setPatient_Id((long)1);
//		patient.setContact_Number((long)1);
//		Mockito.lenient().when(patientRepository.searchPatientByPatient_Name(patient.getPatient_Name())).thenReturn(patientInduction);
//		Mockito.lenient().when(patientService.update(patient.getPatient_Name(), patient.getPatient_Id(), patient)).thenReturn(patient);
//		ResponseEntity responseEntity = new ResponseEntity<>(patient, HttpStatus.CREATED);
//		Mockito.lenient().when(PatientController.updateBook(patient.getId(), patient.getUserid(), patient)).thenReturn(responseEntity);
//		assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
//	}
	
	@Test
	public void getallPatients() {
		List<Patient> patient1 = new ArrayList<Patient>();
		Patient patient = new Patient();
		patient.setPatient_Id(1L);
		patient.setPatient_Name("Akhil");
		patient.setPatient_Address("hyd");
		patient.setDOB("11-11-1990");
		patient.setEmail("akhil@gmail.com");
		patient.setContact_Number(987654321L);
		patient.setDrug_Id(123456L);
		patient.setDrug_Name("dolo");
		
//		controller.getPatients();
		patient1.add(patient);
//		Mockito.lenient().when(patientService.getPatients()).thenReturn(patient1);
		Mockito.lenient().when(patientRepository.findAll()).thenReturn(patient1);
		assertEquals((patientService.getPatients()), patient1);
//		controller.getPatients();
		
//		ResponseEntity responseEntity = ResponseEntity.ok("success");
//		assertEquals((controller.getPatients().getBody()), patient1);
		
		
		
	}
	
//	@Test
//	public void testsaveonepatients() {
//		when(patientRepository.save(any()).thenReturn(patientInduction);
//		
//		
//	}

}
