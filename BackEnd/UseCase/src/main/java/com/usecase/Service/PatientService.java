package com.usecase.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	

}
