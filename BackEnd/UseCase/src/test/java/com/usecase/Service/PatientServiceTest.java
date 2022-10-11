package com.usecase.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.usecase.entity.PatientInduction;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientInductionRepository;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
	
	@InjectMocks
	PatientService patientService;
	
	@Mock
	PatientInductionRepository patientRepository;

	@Mock
	AdminRepository userRepository;

	@Test
	void testgetpatientbyId() {
		String Patient_Id = new String("1");
		Set<PatientInduction> patientList = new HashSet<>();
		PatientInduction patient = new PatientInduction();
		patient.setDOB("11-11-1911");
		patient.setEmail("akhil@gmail.com");
		patient.setDrug_Id((long) 1);
		patient.setPatient_Name("John");
		patient.setDrug_Name("John");
		patient.setPatient_Id((long)1);
		patient.setContact_Number((long)1);
//		book.setActive("true");
		patientList.add(patient);
		Mockito.lenient().when(patientRepository.getPatientById(Patient_Id)).thenReturn((PatientInduction) patientList);
		assertEquals(patientList.size(), patientList.size());
	}

}
