package com.javacodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacodes.model.EmployeeModel;

@Repository
public interface EmployeeModelRepository extends JpaRepository<EmployeeModel, Long> {
	
	

}
