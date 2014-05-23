package com.endava.jpa.service.impl;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public void save(Employee toBeSaved) {
		employeeDao.save(toBeSaved);
	}

	public void update(Employee toBeUpdated) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Employee toBeRemoved) {
		// TODO Auto-generated method stub
		
	}
}
