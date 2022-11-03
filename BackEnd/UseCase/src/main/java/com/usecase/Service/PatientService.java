package com.usecase.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.usecase.entity.Patient;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientInductionRepository;

@Transactional
@Service
public class PatientService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	PatientInductionRepository patientInductionRepository;
	
	
		@Transactional("rollbackFor= [java.sql.SQLException]")
	 public Patient update(@Valid @RequestBody Patient patient1 )
	 {
		  
		  
			
		  Optional<Patient> p1=patientInductionRepository.findById(patient1.getPatient_Id());
		  Patient updatepatient=new Patient();
		  updatepatient.setPatient_Id(patient1.getPatient_Id());
		  updatepatient.setContact_Number(patient1.getContact_Number());
		  updatepatient.setPatient_Address(patient1.getPatient_Address());
		  updatepatient.setEmail(patient1.getEmail());
		  updatepatient.setPatient_Name(patient1.getPatient_Name());
		  updatepatient.setDOB(patient1.getDOB());
		  updatepatient.setDrug_Id(patient1.getDrug_Id());
		  updatepatient.setDrug_Name(patient1.getDrug_Name());
		  
		  return patientInductionRepository.save(updatepatient);
	  } 
	 
	 public Patient getPatientId(String Patient_Id) {
			return patientInductionRepository.getPatientById(Patient_Id);
		}
	 
	 public List<Patient> getPatients() {
		    return patientInductionRepository.findAll();
		  }

	
	

}
