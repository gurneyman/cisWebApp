package com.tomprince.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.CourseSectionDao;
import com.tomprince.domain.CourseSection;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseSectionServiceImpl implements CourseSectionService{

	@Autowired
	private CourseSectionDao courseSectionDao;
	
	@Override
	public List<CourseSection> getAll() {
		return courseSectionDao.getAll();
	}

	@Override
	public CourseSection getByIndex(String index) {
		return courseSectionDao.getByIndex(index);
	}

	@Override
	public Map<String, Map> getByDate(String semesterId, String discipline, String departmentId, String courseNumber, String days, String timeMod, String time, String instructorLastName) {
		return courseSectionDao.getByDate(semesterId, discipline, departmentId, courseNumber, days, timeMod, time, instructorLastName);
	}

	@Override
	public CourseSection getByCode(String code) {
		return courseSectionDao.getByCode(code);
	}

	@Override
	public List<CourseSection> getBySection(String discipline, String courseNumber, String courseSection) {
		// TODO Auto-generated method stub
		return courseSectionDao.getBySection(discipline, courseNumber, courseSection);
	}

}
