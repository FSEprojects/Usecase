package com.usecase.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usecase.entity.PatientInduction;

@Repository

public interface PatientInductionRepository extends JpaRepository<PatientInduction, Long> {
	
	
	@Query(value = "select * from Patient p where p.Patient_id=:id", nativeQuery = true)
	Iterable<PatientInduction> searchPatientByid(@Param("id") Long id);
	
	@Query(value = "select * from Patient p where p.Patient_Name=:Patient_Name", nativeQuery = true)
	Set<PatientInduction> searchPatientByPatient_Name(@Param("Patient_Name") String Patient_Name);
	
	
	@Query(value = "select * from Patient p where p.Patient_Address=:Patient_Address", nativeQuery = true)
	Set<PatientInduction> searchPatientByPatient_Address(@Param("Patient_Address") String Patient_Address);
	
	@Query(value = "select * from Patient p where p.DOB=:DOB", nativeQuery = true)
	Set<PatientInduction> searchPatientByDOB(@Param("DOB") String DOB);
	
	@Query(value = "select * from PatientInduction p where p.Email=:Email", nativeQuery = true)
	Set<PatientInduction> searchPatientByEmail(@Param("Email") String Email);
	
	@Query(value = "select * from PatientInduction p where p.Contact_Number=:Contact_Number", nativeQuery = true)
	Set<PatientInduction> searchPatientByContact_Number(@Param("Contact_Number") String Contact_Number);
	
	@Query(value = "select * from PatientInduction p where p.Drug_Id=:Drug_Id", nativeQuery = true)
	Set<PatientInduction> searchPatientByDrug_Id(@Param("Drug_Id") String Drug_Id);
	
	@Query(value = "select * from PatientInduction p where p.Drug_Name=:Drug_Name", nativeQuery = true)
	Set<PatientInduction> searchPatientByDrug_Name(@Param("Drug_Name") String Drug_Name);
	
	@Query(value = "select * from PatientInduction p where p.Patient_id=:Patient_id", nativeQuery = true)
	PatientInduction getPatientById(@Param("Patient_id") String Patient_id);

	

}
