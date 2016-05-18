package com.tomprince.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISCIPLINE_SR")
public class Discipline {
	
	@Column(name = "DEPT_ID")
	private String departmentId;
	
	@Id
	@Column(name = "DISC_ABBREVIATION")
	private String abbreviation;
	
	@Column(name = "DISCIPLINE_NAME")
	private String name;
	
	@Column(name = "SCHOOL_ID")
	private String schoolId;

	@Override
	public String toString() {
		return "Discipline [departmentId=" + departmentId + ", abbreviation=" + abbreviation + ", name=" + name
				+ ", schoolId=" + schoolId + "]";
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
}
