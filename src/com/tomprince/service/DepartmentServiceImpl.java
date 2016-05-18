package com.tomprince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.DepartmentDao;
import com.tomprince.domain.Department;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public List<Department> getAll() {
		return departmentDao.getAll();
	}

	@Override
	public Department getById(String id) {
		return departmentDao.getById(id);
	}

	@Override
	public Department getByName(String name) {
		return departmentDao.getByName(name);
	}
	
}