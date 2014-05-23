package com.endava.jpa.service.impl;

import com.endava.jpa.model.Department;
import com.endava.jpa.model.Employee;
import com.endava.jpa.service.DepartmentService;
import com.endava.jpa.service.EmployeeService;
import com.endava.jpa.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAMainService {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ProjectService projectService;

	//-------------------------------------- Department -----------------------------/

	public void findDepartment() {
		Department department = departmentService.find(1);
		System.out.println(department);
	}

	public void findDepartmentByName() {
		List<Department> departments = departmentService.find("Prj");
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	/**
	 *   Define a new department entity and insert it into the corresponding table
	 */
	public void insertDepartment() {
		Department dept = new Department();
		dept.setName("HR");
		departmentService.save(dept);
	}

	/**
	 * Search for an existing department, update its name and save it using the new name
	 */
	public void updateDepartment() {
		Department dept = departmentService.find(3);
		if (dept != null) {
			dept.setName("Management");
			departmentService.update(dept);
		}

	}

	/**
	 * Delete an existing department from the database
	 */
	public void deleteDepartment() {
		Department dept = departmentService.find(8);
		if (dept != null) {
			departmentService.remove(dept);
		}
	}

	//-------------------------------------- Employee -----------------------------/
	/**
	 * Create a new employee entity and save it into the corresponding table
	 */
	public void insertEmployee() {
		Employee employee = new Employee();
		employee.setBirthday("1990-12-09");
		employee.setCity("Bucharest");
		employee.setDeprtment(null);
		employee.setId(1221);
		employee.setName("Avram Ion");
		employee.setSalary("2500");
		employee.setZip_code("998800");
		employeeService.save(employee);
	}

	/**
	 * Print to stdout all the employees from 'Bucharest', which belong to the department with id = 1.
	 * Make sure that there are more than two employees in Bucharest which belong to the department with id=1 when populating the DB.
	 * ! Use a join query.
	 */
	public void getEmployeesFromBucharest(){}

	/**
	 * Give a salary raise(+10%) for all employees that work in the 'Endava' project (project name = 'Endava').
	 * ! Use a join query.
	 */
	public void giveSalaryRaise(){}


	//-------------------------------------- Project -----------------------------/

	/**
	 * Add a new employee to the 'Endava' project. (project name = 'Endava')
	 */
	public void addEmployee(){}

	/**
	 * Remove an employee from a project which has 'John Doe' as project manager.
	 */
	public void removeEmployee(){}

}
