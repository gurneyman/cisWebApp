package com.tomprince.service;

import java.util.List;

import com.tomprince.domain.Department;

public interface DepartmentService {
	public List<Department> getAll();
	public Department getById(String id);
	public Department getByName(String name);
}
