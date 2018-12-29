package com.babis.theodorou.CRUD_DEMO.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babis.theodorou.CRUD_DEMO.entity.Employee;
import com.babis.theodorou.CRUD_DEMO.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee thEmployee = employeeService.findById(employeeId);
		
		if(thEmployee==null) {
			throw new RuntimeException("Employee with id=" + employeeId +" not found");
		}
		
		return thEmployee;
		
		
	}
	
	@PostMapping("employees")
	public Employee addEmployee(@RequestBody Employee thEmployee) {
		// just in case someone pass an id in post method
		thEmployee.setId(0);
		
		employeeService.save(thEmployee);
		
		return thEmployee;
		
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee thEmployee) {
		
		employeeService.save(thEmployee);
		
		return thEmployee;
		
	}
	
	
	@DeleteMapping("/employees/{employeeId")
	public String deleteEmployeee(@PathVariable int emploeeId) {
		
		Employee tEmployee = employeeService.findById(emploeeId);
		
		if(tEmployee==null) {
			throw new RuntimeException("This Employee does not exist.");
		}
		employeeService.deleteById(emploeeId);	
			
			
		return "Employeed Deleted";
		
	
		
	}
	
	
	
}
