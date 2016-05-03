package com.tomprince.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "SEMESTER_SR")
public class Semester {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "SEMESTER_ID")
	private String semesterId;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "START_DATE")
	private Date startDate;
	
	@NotNull // These could possibly allow nulls since you may only want to edit one value!
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "SEMESTER_NAME")
	private String semesterName;
	
	@Column(name = "SEMESTER")
	private String semester;
	
	public Semester() {}
	
	
	@Override
	public String toString() {
		return "Semester [semesterId=" + semesterId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", semesterName=" + semesterName + ", semester=" + semester + "]";
	}


	public String getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}
