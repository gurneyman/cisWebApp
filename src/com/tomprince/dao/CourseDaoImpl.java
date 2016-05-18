package com.tomprince.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.Course;

@Repository("CourseDao") 
public class CourseDaoImpl implements CourseDao{
	
	@Autowired  
    private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Course> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Course.class).list();
	}

	@Override
	@Transactional
	public Course getByNumber(String discipline, String number) {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Course.class);
		criteria.add(Restrictions.eq("discipline", discipline)).add(Restrictions.eq("number", number));
		return (Course) criteria.list().get(0);
	}

}
