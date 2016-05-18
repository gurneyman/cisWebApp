package com.tomprince.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.domain.Discipline;

@Repository("DisciplineDao")
public class DisciplineDaoImpl implements DisciplineDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	@Transactional
	public Discipline getByAbbreviation(String abbreviation) {
		return (Discipline) sessionfactory.getCurrentSession().get(Discipline.class, abbreviation);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Discipline> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Discipline.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Discipline> getById(String departmentId) {
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(Discipline.class);
		criteria.add(Restrictions.eq("departmentId", departmentId));
		return criteria.list();
	}

}
