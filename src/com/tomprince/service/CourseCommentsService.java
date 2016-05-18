package com.tomprince.service;

import java.util.List;

import com.tomprince.domain.CourseComments;

public interface CourseCommentsService {
	public List<CourseComments> getAll();
	public CourseComments getByCourseCode(String courseCode);
}