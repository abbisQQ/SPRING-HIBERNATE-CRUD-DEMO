package com.babis.theodorou.CRUD_DEMO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.babis.theodorou.CRUD_DEMO.DAO.EmployeeDao;
import com.babis.theodorou.CRUD_DEMO.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImp(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDao.save(employee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}

}
