package com.babis.theodorou.CRUD_DEMO.service;

import java.util.List;

import com.babis.theodorou.CRUD_DEMO.entity.Employee;

public interface EmployeeService {
	
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void  save(Employee employee);
	
	public void deleteById(int theId);
	
	
	

}
