package com.tomprince.service;
  

import java.util.List;

import com.tomprince.domain.Semester;  

public interface SemesterService {  
    public void addUser(Semester semster);  
    public List<Semester> getSemesters();  
    public Semester getSemester(String string);
	public void updateSemester(Semester oldSemester);
} 
