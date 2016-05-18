package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.Discipline;

public interface DisciplineDao {
	public Discipline getByAbbreviation(String abbreviation);
	public List<Discipline> getById(String departmentId);
	public List<Discipline> getAll();
}
