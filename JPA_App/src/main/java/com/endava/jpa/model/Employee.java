package com.endava.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Georgiana Danila
 *
 * 
 */
@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int id;
	private String name;
	private String salary;
	@ManyToOne
	@JoinColumn(name="dept_id",referencedColumnName="id")
	private Department department;
	private String street;
	private String city;
	private String state;
	private String zip_code;
	private String birthday;
	@ManyToMany
	@JoinTable(name="emplproject", joinColumns=@JoinColumn(name="idemployee"),inverseJoinColumns=@JoinColumn(name="idproject"))
	private List<Project> projects;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", deprtment=" + department + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zip_code=" + zip_code
				+ ", birthday=" + birthday + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Department getDeprtment() {
		return department;
	}
	public void setDeprtment(Department deprtment) {
		this.department = deprtment;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
