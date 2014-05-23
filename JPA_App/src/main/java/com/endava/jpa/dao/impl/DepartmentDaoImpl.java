package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.DepartmentDao;
import com.endava.jpa.model.Department;

import org.springframework.stereotype.Repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Department find(int id) {
		return entityManager.find(Department.class, id);
	}

	public List<Department> find(String departmentName) {
		Query query = entityManager.createNamedQuery("Department.getByName");
		query.setParameter("departmentName",departmentName);
		return query.getResultList();
	}

	public void save(Department toBeSaved) {
		entityManager.persist(toBeSaved);
		entityManager.flush();
	}

	public Department update(Department toBeUpdated) {
		return entityManager.merge(toBeUpdated);
	}

	public void remove(Department toBeRemoved) {
		entityManager.remove(toBeRemoved);
	}
}
