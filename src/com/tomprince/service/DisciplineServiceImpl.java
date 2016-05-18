package com.tomprince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.DisciplineDao;
import com.tomprince.domain.Discipline;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DisciplineServiceImpl implements DisciplineService{
	
	@Autowired
	private DisciplineDao disciplineDao;
	
	@Override
	public List<Discipline> getAll() {
		return disciplineDao.getAll();
	}

	@Override
	public Discipline getByAbbreviation(String abbreviation) {
		return disciplineDao.getByAbbreviation(abbreviation);
	}
}
