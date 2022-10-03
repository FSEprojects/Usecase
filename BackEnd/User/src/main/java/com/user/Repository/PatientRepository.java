package com.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.Entity.Patient;

@Repository

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	@Query(value = "SELECT * FROM patient.patient WHERE patient_name=?1", nativeQuery = true)
	public Patient getPatientDetails(String Patient_Name);
	
	public	Patient createpatientdetails(Patient patient);

	public Patient searchPatientByName(String patient_Name);

//	public Patient updatePatient(String patient_Name);

	public Patient updatePatient(Patient patient, String patient_Name);

}
