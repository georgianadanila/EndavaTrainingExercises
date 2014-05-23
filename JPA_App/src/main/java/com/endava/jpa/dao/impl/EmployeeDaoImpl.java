package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;


	public void save(Employee toBeSaved) {
		entityManager.persist(toBeSaved);
		entityManager.flush();
	}

	public void update(Employee toBeUpdated) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Employee toBeRemoved) {
		// TODO Auto-generated method stub
		
	}
}
