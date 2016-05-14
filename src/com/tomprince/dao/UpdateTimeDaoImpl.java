package com.tomprince.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.UpdateTime;

@Repository("UpdateTimeDao")
public class UpdateTimeDaoImpl implements UpdateTimeDao {
	
	@Autowired
	private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public UpdateTime getBySemester(String semester) {
		return (UpdateTime) sessionfactory.getCurrentSession().get(UpdateTime.class, semester);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UpdateTime> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(UpdateTime.class).list();
	}

}
