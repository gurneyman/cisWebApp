package com.tutorialspoint.dao;

import java.util.List;  
import com.tutorialspoint.domain.Semester;  
  
  
public interface SemesterDao {  
public void saveUser ( Semester semester );  
public List<Semester> getSemesters();  
  
} 
