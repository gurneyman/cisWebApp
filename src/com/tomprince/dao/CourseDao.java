package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.Course;  
  
  
public interface CourseDao {  
	public List<Course> getAll();
	public Course getByNumber(String discipline, String number);
}  

