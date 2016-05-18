package com.tomprince.service;

import java.util.List;

import com.tomprince.domain.Instructor;

public interface InstructorService {
	public List<Instructor> getAll();
	public Instructor getByCourseCode(String code);
}
