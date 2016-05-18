package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.CourseComments;  
  
public interface CourseCommentsDao {  
	public List<CourseComments> getAll();
	public CourseComments getByCode(String code);
}  

