package com.babis.theodorou.CRUD_DEMO.DAO;

import java.util.List;

import com.babis.theodorou.CRUD_DEMO.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void  save(Employee employee);
	
	public void deleteById(int theId);
	

}
