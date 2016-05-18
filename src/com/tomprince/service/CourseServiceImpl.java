package com.tomprince.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.CourseDao;
import com.tomprince.domain.Course;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	@Override
	public List<Course> getAll() {
		return courseDao.getAll();
	}

	@Override
	public Course getByNumber(String discipline, String number) {
		return courseDao.getByNumber(discipline, number);
	}

}
