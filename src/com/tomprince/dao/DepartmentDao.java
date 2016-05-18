package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.Department;

public interface DepartmentDao {
	public List<Department> getAll();
	public Department getById(String id);
	public Department getByName(String name);
}
