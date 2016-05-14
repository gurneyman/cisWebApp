package com.tomprince.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tomprince.dao.UpdateTimeDao;
import com.tomprince.domain.UpdateTime;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
public class UpdateTimeServiceImpl implements UpdateTimeService {
	
	@Autowired
	private UpdateTimeDao updateTimeDao;

	@Override
	public List<UpdateTime> getAll() {
		return updateTimeDao.getAll();
	}

	@Override
	public UpdateTime getBySemester(String semester) {
		return updateTimeDao.getBySemester(semester);
	}

}
