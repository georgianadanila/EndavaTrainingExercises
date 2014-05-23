package com.endava.jpa.service;

import com.endava.jpa.model.Department;

import java.util.List;

public interface DepartmentService {

	public Department find(int id);

	public List<Department> find(String departmentName);

	public void save(Department toBeSaved);

	public Department update(Department toBeUpdated);

	public void remove(Department toBeRemoved);
}
