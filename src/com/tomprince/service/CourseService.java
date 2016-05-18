package com.tomprince.service;

import java.util.List;

import com.tomprince.domain.Course;

public interface CourseService {
	public List<Course> getAll();
	public Course getByNumber(String discipline, String number);
}
