package com.usecase.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import com.usecase.Csv.CsvHelper;
import com.usecase.entity.Patient;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientInductionRepository;


@ExtendWith(MockitoExtension.class)
class CSVServiceTest {
	
	@InjectMocks
	CSVService patientService;
	
	@Mock
	PatientInductionRepository patientRepository;

	@Mock
	AdminRepository userRepository;

	@Test
	public void csvservicetest() throws IOException{
		FileInputStream inputfile= new FileInputStream("D:\\UseCase\\BackEnd\\UseCase\\csv.csv");
		MockMultipartFile file = new MockMultipartFile("file","patient","multipart/form-data",inputfile);
		List<Patient> patientsList = CsvHelper.csvToPatient(file.getInputStream());
		Mockito.lenient().when(patientRepository.saveAll(patientsList)).thenReturn(patientsList);
		patientService.save(file);
		
	}

}
