package com.tomprince.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CRS_SEC_SR")
public class CourseSection {
	
	@Id
	@Column(name = "CRS_INDEX")
	private String courseIndex;
	
	@Column(name = "D_E_G") 
	private String d_e_g;
	
	@Column(name = "DISC")
	private String discipline;
	
	@Column(name = "CRS_NUM")
	private String courseNumber;
	
	@Column(name = "CRS_SEC")
	private String sectionCode;
	
	@Column(name = "CRS_CD")
	private String courseCode;
	
	@Column(name = "MEETING_DAYS")
	private String days;
	
	@Column(name = "START_TIME")
	private String startTime;
	
	@Column(name = "STOP_TIME")
	private String stopTime;
	
	@Column(name = "AM_PM")
	private String dayPeriod;
	
	@Column(name = "SEATS_AVAIL")
	private int seatsAvailable;
	
	@Column(name = "BUILDING")
	private String building;
	
	@Column(name = "RM")
	private String room;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "START_DATE")
	private Date startDate;
	
	@NotNull
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "INSTRUCTOR_LNAME")
	private String instructorLastName;
	
	@Column(name = "SEMESTER")
	private String semester;
	
	public CourseSection() {}

	@Override
	public String toString() {
		return "CourseSection [courseIndex=" + courseIndex + ", d_e_g=" + d_e_g + ", discipline=" + discipline
				+ ", courseNumber=" + courseNumber + ", sectionCode=" + sectionCode + ", courseCode=" + courseCode
				+ ", days=" + days + ", startTime=" + startTime + ", stopTime=" + stopTime + ", dayPeriod=" + dayPeriod
				+ ", seatsAvailable=" + seatsAvailable + ", building=" + building + ", room=" + room + ", startDate="
				+ startDate + ", endDate=" + endDate + ", instructorLastName=" + instructorLastName + ", semester="
				+ semester + "]";
	}

	public String getCourseIndex() {
		return courseIndex;
	}

	public void setCourseIndex(String courseIndex) {
		this.courseIndex = courseIndex;
	}

	public String getD_e_g() {
		return d_e_g;
	}

	public void setD_e_g(String d_e_g) {
		this.d_e_g = d_e_g;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getDayPeriod() {
		return dayPeriod;
	}

	public void setDayPeriod(String dayPeriod) {
		this.dayPeriod = dayPeriod;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
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

	public String getInstructorLastName() {
		return instructorLastName;
	}

	public void setInstructorLastName(String instructorLastName) {
		this.instructorLastName = instructorLastName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
}
