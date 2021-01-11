package com.javacodes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacodes.model.EmployeeModel;
import com.javacodes.repository.EmployeeModelRepository;

@Service
public class EmployeeServiceLeyarImpl implements EmployeeServiceLeyar {
	
	@Autowired
	private EmployeeModelRepository repository;

	@Override
	public List<EmployeeModel> getAllEmployes() {
		return repository.findAll();
	}

	@Override
	public void saveEmployee(EmployeeModel employee) {
		this.repository.save(employee);

	}

	@Override
	public EmployeeModel getEmployeeById(long id) {
		     
		Optional<EmployeeModel> optional = repository.findById(id);
		
		EmployeeModel employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		     
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.repository.deleteById(id);
		

	}

}