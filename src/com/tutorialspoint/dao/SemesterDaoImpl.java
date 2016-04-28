package com.tutorialspoint.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.domain.Semester;

@Repository("SemesterDao")
public class SemesterDaoImpl implements SemesterDao  {
	
	@Autowired  
    private SessionFactory sessionfactory;
	
	@Override
	@Transactional
	public void saveUser(Semester semester) {
		sessionfactory.getCurrentSession().saveOrUpdate(semester);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Semester> getSemesters() {
       	return sessionfactory.getCurrentSession().createCriteria(Semester.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Semester getSemester(String id) {
		return (Semester) sessionfactory.getCurrentSession().get(Semester.class, id);
	}

	@Override
	@Transactional
	public void updateSemester(Semester semester) {
		sessionfactory.getCurrentSession().saveOrUpdate(semester);
	}

}
