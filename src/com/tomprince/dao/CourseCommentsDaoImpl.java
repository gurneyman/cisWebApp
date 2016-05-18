package com.tomprince.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.CourseComments;

@Repository("CourseCommentsDao") 
public class CourseCommentsDaoImpl implements CourseCommentsDao{
	
	@Autowired  
    private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<CourseComments> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(CourseComments.class).list();
	}

	@Override
	@Transactional
	public CourseComments getByCode(String code) {
		return (CourseComments) sessionfactory.getCurrentSession().get(CourseComments.class, code);
	}

}
