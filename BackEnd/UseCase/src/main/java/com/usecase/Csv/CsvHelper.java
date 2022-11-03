package com.usecase.Csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.usecase.entity.Patient;

public class CsvHelper {
	
	public static String TYPE = "text/csv";
	  static String[] HEADERs = { "Patient_Id", "Patient_Name", "Patient_Address", "DOB","Email","Contact_Number","Drug_Id","Drug_Name" };
	  
	  public static boolean hasCSVFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }
	  
	  public static List<Patient> csvToPatient(InputStream is) {
		  System.out.println("at csvhelper");
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
		    	 
		      List<Patient> patientlist = new ArrayList<Patient>();

		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		      for (CSVRecord csvRecord : csvRecords) {
		    	  if (csvRecord.get("Email").isBlank() || (csvRecord.get("Email").isEmpty())) {

						throw new NullPointerException("patient_email is null");
					}
					if (csvRecord.get("Patient_Name").isBlank() || (csvRecord.get("Patient_Name").isEmpty())) {

						throw new NullPointerException("patient_name is null");
					}
					if (csvRecord.get("Patient_Address").isBlank() || (csvRecord.get("Patient_Address").isEmpty())) {

						throw new NullPointerException("patient_address is null");
					}
					if (csvRecord.get("DOB").isBlank() || (csvRecord.get("DOB").isEmpty())) {

						throw new NullPointerException("dob is null");
					}
					if (csvRecord.get ("Drug_Name").isBlank() || (csvRecord.get("Drug_Name").isEmpty())) {

						throw new NullPointerException("drug_name is null");
					}
		    	  
		    	 
		    	  Patient patient = new Patient(
		    			  Long.parseLong(csvRecord.get("Patient_Id")), 
		    			  csvRecord.get("Patient_Name"),
		    			  csvRecord.get("Patient_Address"),
		    			  csvRecord.get("DOB"), 
		    			csvRecord.get("Email"),
		    			Long.parseLong(csvRecord.get("Contact_Number")),
		    	  Long.parseLong(csvRecord.get("Drug_Id")),
		    			  csvRecord.get("Drug_Name"));
		    	  patientlist.add(patient);
		    	  
		    	  System.out.println("get");
		    	  
		    	 
		      }
		    
		      return patientlist;
		      
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }

}
