package com.tomprince.domain;

import javax.persistence.*;

@Entity
@Table(name = "COURSE_SR")
public class Course {
	@Column(name = "LEVEL_DIV")
	private String level;

	@Column(name = "DISCIPLINE")
	private String discipline;

	@Id
	@Column(name = "COURSENUMBER")
	private String number;

	
	@Column(name = "TITLE")
	private String title;

	
	@Column(name = "CREDITHOUR")
	private String creditHour;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PREREQ")
	private String prerequisite;
	
	

	public String getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(String prerequisite) {
		this.prerequisite = prerequisite;
	}

	public Course() {}
	
	@Override
	public String toString() {
		return "Course [level=" + level + ", discipline=" + discipline + ", number=" + number + ", title=" + title
				+ ", creditHour=" + creditHour + ", description=" + description + "]";
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreditHour() {
		return creditHour;
	}

	public void setCreditHour(String creditHour) {
		this.creditHour = creditHour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
