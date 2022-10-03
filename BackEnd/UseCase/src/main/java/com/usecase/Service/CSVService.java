package com.usecase.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.Csv.CsvHelper;
import com.usecase.entity.PatientInduction;
import com.usecase.repository.PatientInductionRepository;


@Service

public class CSVService {
	
	
	
	@Autowired
	PatientInductionRepository patientInductionRepository;
	
	public void save(MultipartFile file) {
//		 System.out.println("call at save");
	    try {
	      List<PatientInduction> patientslist = CsvHelper.csvToPatient(file.getInputStream());
	      patientslist.forEach(System.out::println);
	      patientInductionRepository.saveAll(patientslist);
//	      System.out.println("call after repo");
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

	  public List<PatientInduction> getPatients() {
	    return patientInductionRepository.findAll();
	  }

}
