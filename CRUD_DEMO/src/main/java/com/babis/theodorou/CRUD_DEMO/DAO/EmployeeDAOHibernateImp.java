package com.babis.theodorou.CRUD_DEMO.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.babis.theodorou.CRUD_DEMO.entity.Employee;


@Repository
public class EmployeeDAOHibernateImp implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery =
				session.createQuery("FROM Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class,theId);
		
		
		return theEmployee;
	}


	@Override
	public void save(Employee employee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
		
	}


	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query deleteQuery =  currentSession.createQuery("delete from Employee where id=:employeeId");
		
		deleteQuery.setParameter("employeeId", theId);
		
		deleteQuery.executeUpdate();
		
		
		
	}

	

}
