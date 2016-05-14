package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.UpdateTime;

public interface UpdateTimeDao {
	public UpdateTime getBySemester(String semester);
	public List<UpdateTime> getAll();
}
