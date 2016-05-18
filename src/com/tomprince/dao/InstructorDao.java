package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.Instructor;

public interface InstructorDao {
	public Instructor getByCourseCode(String code);
	public List<Instructor> getAll();
}
