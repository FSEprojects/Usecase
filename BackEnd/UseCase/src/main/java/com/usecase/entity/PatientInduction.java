package com.usecase.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Patient", uniqueConstraints = { @UniqueConstraint(columnNames = "Patient_Id") })
public class PatientInduction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Patient_Id;
	@NotBlank(message="Patient_Name cannot be blank")
	@Size(min=5,max=30)
	private String Patient_Name;
	@NotBlank(message="Patient_Address cannot be blank")
	private String Patient_Address;
	@NotBlank(message="DOB cannot be blank")
	@DateTimeFormat(pattern="MM-DD-YYYY")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Long DOB;
	@NotBlank(message="Email cannot be blank")
//	@email("Email should be valid")
	private String Email;
	@NotBlank(message="Contact_Number cannot be blank")
	@Size(min=10,max=10)
	private Long Contact_Number;
	@NotBlank(message="Drug_Id cannot be blank")
	@NumberFormat(pattern="XXXXX-XXXX-XX")
	private int Drug_Id;
	@NotBlank(message="Drug_Name cannot be blank")
	private String Drug_Name;
	
	public PatientInduction()
	{
		
	}
	public PatientInduction(Long Patient_Id,String Patient_Name,String Patient_Address,Long DOB,String Email,Long Contact_Number,int Drug_Id,String Drug_Name)
	{
		this.Patient_Id=Patient_Id;
		this.Patient_Name=Patient_Name;
		this.Patient_Address=Patient_Address;
		this.DOB=DOB;
		this.Email=Email;
		this.Contact_Number=Contact_Number;
		this.Drug_Id=Drug_Id;
		this.Drug_Name=Drug_Name;
	}
	
	@Override
	  public String toString() {
	    return " [Patient_Id=" + Patient_Id + ", Patient_Name=" + Patient_Name + ", Patient_Address=" + Patient_Address + ", "
	    		+ "DOB=" + DOB + ",Email=" + Email + ",Contact_Number="+Contact_Number+","
	    				+ "Drug_Id="+Drug_Id+",Drug_Name="+Drug_Name+"]";
	  }
	public List<PatientInduction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public void saveAll(List<PatientInduction> patientslist) {
		// TODO Auto-generated method stub
		return;
		
	}

}
