package com.tomprince.domain;

import javax.persistence.*;

@Entity
@Table(name = "INSTRUCTOR_SR")
public class Instructor {
	
	@Id
	@Column(name = "CRS_CD")
	private String courseCode;
	
	@Column(name = "INSTRUCTOR_LNAME")
	private String lastName;
	
	@Column(name = "SEMESTER")
	private String semester;

	public Instructor() {}

	@Override
	public String toString() {
		return "Instructor [courseCode=" + courseCode + ", lastName=" + lastName + ", semester=" + semester + "]";
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}	
}