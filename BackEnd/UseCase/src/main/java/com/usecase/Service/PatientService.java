package com.usecase.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.usecase.entity.PatientInduction;
import com.usecase.repository.AdminRepository;
import com.usecase.repository.PatientInductionRepository;

@Service
public class PatientService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	PatientInductionRepository patientInductionRepository;
	
	
//	public PatientInduction loadpatientdata( PatientInduction patientInduction) {
//		Optional<PatientInduction> PatientInductionToUpdate = patientInductionRepository.findById((long) Id);
//		if (PatientInductionToUpdate.isPresent()) {
//			PatientInduction loadpatientdata = PatientInductionToUpdate.get();
//			loadpatientdata.setPatient_Name(patientInduction.getPatient_Name());
//			loadpatientdata.setPatient_Address(patientInduction.getPatient_Address());
//			loadpatientdata.setDOB(patientInduction.getDOB());
//			loadpatientdata.setEmail(patientInduction.getEmail());
//			loadpatientdata.setContact_Number(patientInduction.getContact_Number());
//			loadpatientdata.setDrug_Id(patientInduction.getDrug_Id());
//			loadpatientdata.setDrug_Name(patientInduction.getDrug_Name());
//			return patientInductionRepository.save(loadpatientdata);
//		}
//
//		return null;
//
//	}
	 public PatientInduction update(@Valid @RequestBody PatientInduction patient1 )
	  {
		  
		  
			
		  Optional<PatientInduction> p1=patientInductionRepository.findById(patient1.getPatient_Id());
		  PatientInduction updatepatient=new PatientInduction();
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
	 
	 public PatientInduction getPatientId(String Patient_Id) {
			return patientInductionRepository.getPatientById(Patient_Id);
		}
	 
	 public List<PatientInduction> getPatients() {
		    return patientInductionRepository.findAll();
		  }

	
	

}
