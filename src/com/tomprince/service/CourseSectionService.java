package com.tomprince.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tomprince.domain.CourseSection;

public interface CourseSectionService {
	public List<CourseSection> getAll();
	public Map<String, Map> getByDate(String semesterId, String discipline, String departmentId, String courseNumber, String days, String timeMod, String time, String instructorLastName);
	public CourseSection getByIndex(String index);
	public CourseSection getByCode(String code);
	public List<CourseSection> getBySection(String discipline, String courseNumber, String courseSection);
}