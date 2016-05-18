package com.tomprince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.InstructorDao;
import com.tomprince.domain.Instructor;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InstructorServiceImpl implements InstructorService{
	
	@Autowired
	private InstructorDao instructorDao;
	
	@Override
	public List<Instructor> getAll() {
		return instructorDao.getAll();
	}

	@Override
	public Instructor getByCourseCode(String code) {
		return instructorDao.getByCourseCode(code);
	}

}
