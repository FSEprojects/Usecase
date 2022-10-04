package com.usecase.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.Csv.CsvHelper;
import com.usecase.Service.CSVService;
import com.usecase.Service.PatientService;
import com.usecase.entity.PatientInduction;
import com.usecase.message.message;
import com.usecase.repository.PatientInductionRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class PatientController {
	
	@Autowired
	PatientInductionRepository patientInductionRepository;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	CSVService fileservice;
	
	@Autowired
	RestTemplate restTemplate;
	
//	@PostMapping("/load/patientdata")
//	ResponseEntity<?> loadpatientdata(@Valid @RequestBody PatientInduction patientInduction){
//		
//		if (!patientInductionRepository.existsById((long) Id)) {
//			return new ResponseEntity<>("Author does not exist", HttpStatus.UNAUTHORIZED);
//		}
//		PatientInduction.setId(id);
//		PatientInduction loadpatientdata = PatientService.loadpatientdata(Id, patientInduction);
//		if (loadpatientdata == null) {
//			return new ResponseEntity<>("Patient Data does not exist", HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(loadpatientdata, HttpStatus.CREATED);
//		
//		
//	}
	@PostMapping("/upload")
	  public ResponseEntity<message> uploadFile(@RequestParam(value = "file") MultipartFile file) {
	    String message = "";
	    System.out.println("befor if");
	    if (CsvHelper.hasCSVFormat(file)) {
	      try {
	    	  System.out.println("befor file");
	    	  fileservice.save(file);
	    	  System.out.println("after file");
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new message(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new message(message));
	      }
	    }

	    message = "Please upload a csv file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new message(message));
	  }
	  @GetMapping("/patients/{patientId}")
		PatientInduction getPatientId(@Valid @PathVariable("patientId") String Patient_Id) {
			return patientService.getPatientId(Patient_Id);
	  }
	  @GetMapping("/patients")
	  public ResponseEntity<List<PatientInduction>> getPatients() {
	    try {
	      List<PatientInduction> patientslist = fileservice.getPatients();

	      if (patientslist.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(patientslist, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PostMapping("/updatepatient")
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
	  
	  @GetMapping("/patientbyid/{patientId}")
	  public Object  getPatientyByid(@Valid @PathVariable("patientId") Long patientId){
		  
		  String url = "http://localhost:8098/load/retrieve/ ";

			PatientInduction patient = this.restTemplate.getForObject(url + patientId, PatientInduction.class);
		  
		  Optional<PatientInduction> getpatient = patientInductionRepository.findById(patientId);

	        return getpatient;
	    }
	
	
	

}
