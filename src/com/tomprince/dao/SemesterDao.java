package com.tomprince.dao;

import java.util.List;

import com.tomprince.domain.Semester;

public interface SemesterDao {
	public void saveUser(Semester semester);

	public List<Semester> getSemesters();

	public Semester getSemester(String id);

	public void updateSemester(Semester semester);

}
