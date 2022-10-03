package com.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Entity.Patient;
import com.user.Repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	


	
	public Patient createpatientdetails(Patient patient) {
		return patientRepository.save(patient);
	}

	
	public Patient searchPatientByName(String patient_Name) {

		Patient response = patientRepository.getPatientDetails(patient_Name);
		return response;
	}

	
//	public Patient updatePatient(String patient_Name) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	public Patient updatePatient(Patient patient, String patient_Name) {
		Patient existingPatient = patientRepository.getPatientDetails(patient_Name);
		 
		 existingPatient.setEmail(patient.getPatient_Name());
		 existingPatient.setPatient_Address(patient.getPatient_Address());
		 existingPatient.setContact_Number(patient.getContact_Number());
		 existingPatient.setPatient_Name(patient.getPatient_Name());
		 existingPatient.setDOB(patient.getDOB());
		 patientRepository.save(existingPatient);
		 return existingPatient;
	}

}
