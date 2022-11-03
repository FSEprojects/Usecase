package com.usecase.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.usecase.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	
	
	@Query(value = "Select * from admin a where a.username=:username", nativeQuery = true)
	public Admin getUser(@Param("username") String username);
	
	
	
	Boolean existsByusername(String username);


}
