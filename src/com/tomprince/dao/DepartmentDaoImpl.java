package com.tomprince.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.Department;

@Repository("DepartmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired  
    private SessionFactory sessionfactory;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Department> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Department.class).list();
	}
	
	@Transactional
	@Override
	public Department getById(String id) {
		return (Department) sessionfactory.getCurrentSession().get(Department.class, id);
	}
	
	@Transactional
	@Override
	public Department getByName(String name) {
		return (Department) sessionfactory.getCurrentSession().get(Department.class, name);
	}

}
