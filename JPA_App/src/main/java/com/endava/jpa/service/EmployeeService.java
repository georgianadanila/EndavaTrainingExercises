package com.endava.jpa.service;

import com.endava.jpa.model.Employee;

public interface EmployeeService {
	
	public void save(Employee toBeSaved);
	
	public void update(Employee toBeUpdated);
	
	public void remove(Employee toBeRemoved);
}
