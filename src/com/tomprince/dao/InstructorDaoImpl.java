package com.tomprince.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.Instructor;

@Repository("InstructorDao")
public class InstructorDaoImpl implements InstructorDao  {
	
	@Autowired  
    private SessionFactory sessionfactory;
	
	@Transactional
	@Override
	public Instructor getByCourseCode(String code) {
		return (Instructor) sessionfactory.getCurrentSession().get(Instructor.class, code);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Instructor> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Instructor.class).list();
	}
}
