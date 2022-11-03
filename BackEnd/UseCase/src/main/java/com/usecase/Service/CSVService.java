package com.usecase.Service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.Csv.CsvHelper;
import com.usecase.entity.Patient;
import com.usecase.repository.PatientInductionRepository;


@Service
@Transactional

public class CSVService {
	
	
	
	@Autowired
	PatientInductionRepository patientInductionRepository;
	
	
	
	public void save(MultipartFile file) {
		 System.out.println("call at save");
	    try {
	      List<Patient> patientslist = CsvHelper.csvToPatient(file.getInputStream());
	      System.out.println("fg");
	      patientslist.forEach(System.out::println);
	      System.out.println("rg");
	      
	      patientInductionRepository.saveAll(patientslist);

//	      System.out.println(patientslist);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<Patient> getPatients() {
	    return patientInductionRepository.findAll();
	  }

}
