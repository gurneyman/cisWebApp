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

/**
 * @author thomas
 *
 */
@Entity
@Table(name = "UPDATE_TIME_SR")
public class UpdateTime {
	
	@Id
	@Column(name = "SEMESTER")
	private String semester;
	
	//@NotNull
	//@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "UPDATE_TIME")
	private String date;
	
	public UpdateTime() {}
	
	@Override
	public String toString() {
		return "UpdateTime [semester=" + semester + ", date=" + date + "]";
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
