package com.tomprince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.CourseCommentsDao;
import com.tomprince.domain.CourseComments;

@Service  
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseCommentsServiceImpl implements CourseCommentsService{

	@Autowired
	private CourseCommentsDao CourseCommentsDao;
	
	@Override
	public List<CourseComments> getAll() {
		return CourseCommentsDao.getAll();
	}

	@Override
	public CourseComments getByCourseCode(String code) {
		return CourseCommentsDao.getByCode(code);
	}

}
