package com.tomprince.service;

import java.util.List;

import com.tomprince.domain.UpdateTime;

public interface UpdateTimeService {
	public List<UpdateTime> getAll();  
    public UpdateTime getBySemester(String semester);
}
