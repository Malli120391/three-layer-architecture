package com.javacodes.services;

import java.util.List;

import com.javacodes.model.EmployeeModel;

public interface EmployeeServiceLeyar {
	
	List<EmployeeModel> getAllEmployes();
	
	void saveEmployee(EmployeeModel employee);
	
	EmployeeModel getEmployeeById(long id);
	
	void deleteEmployeeById(long id);
	

}
