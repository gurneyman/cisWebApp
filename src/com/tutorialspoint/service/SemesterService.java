package com.tutorialspoint.service;
  

import java.util.List;  
import com.tutorialspoint.domain.Semester;  

public interface SemesterService {  
    public void addUser(Semester semster);  
    public List<Semester> getSemesters();  
    public Semester getSemester(String string);
	public void updateSemester(Semester oldSemester);
} 
