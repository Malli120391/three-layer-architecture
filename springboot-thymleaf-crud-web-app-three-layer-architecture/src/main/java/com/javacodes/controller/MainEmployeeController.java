package com.javacodes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.javacodes.model.EmployeeModel;
import com.javacodes.services.EmployeeServiceLeyar;

@Controller
public class MainEmployeeController {
	
	@Autowired
	private EmployeeServiceLeyar employeeServiceLeyar;
	
	@GetMapping("/")
    public String HomePage(Model model) {
        model.addAttribute("listEmployees", employeeServiceLeyar.getAllEmployes());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
    	EmployeeModel employee = new EmployeeModel();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeModel employee) {
        // save employee to database
    	employeeServiceLeyar.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
    	EmployeeModel employee = employeeServiceLeyar.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.employeeServiceLeyar.deleteEmployeeById(id);
        return "redirect:/";
    }
	
	

}
