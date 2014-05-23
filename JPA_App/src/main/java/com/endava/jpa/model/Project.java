package com.endava.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Georgiana Danila
 *
 * 
 */
@Entity
@Table(name="project")
public class Project {

	@Id
	private int id;
	private String name;
	private String projectManager;
	private String description;
	@ManyToMany(mappedBy="projects")
	private List<Employee> employees;
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", projectManager="
				+ projectManager + ", description=" + description + "]";
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
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
