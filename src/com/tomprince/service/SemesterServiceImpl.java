package com.tomprince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.SemesterDao;
import com.tomprince.domain.Semester;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)  
public class SemesterServiceImpl implements SemesterService{
	
	@Autowired
	private SemesterDao semesterDao;
	
	@Override
	public void addUser(Semester semester) {
		semesterDao.saveUser(semester);
		
	}

	@Override
	public List<Semester> getSemesters() {
		return semesterDao.getSemesters();
	}

	@Override
	public Semester getSemester(String id) {
		return semesterDao.getSemester(id);
	}

	@Override
	public void updateSemester(Semester semester) {
		// TODO Auto-generated method stub
		semesterDao.updateSemester(semester);
	}

}
