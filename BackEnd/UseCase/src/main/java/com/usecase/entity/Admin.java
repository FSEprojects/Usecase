package com.usecase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table
@Getter
@Setter
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message="Username cannot be blank")
	private String username;
	@NotBlank(message="Username cannot be blank")
	@Size(min=8,max=20)
	private String password;
//	private String userrole;
	
//	public User() {
//		
//	}

}
