package com.endava.jpa.dao;

import com.endava.jpa.model.Employee;

public interface EmployeeDao {

	public void save(Employee toBeSaved);

	public void update(Employee toBeUpdated);

	public void remove(Employee toBeRemoved);
}
