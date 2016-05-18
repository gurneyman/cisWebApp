package com.tomprince.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CRS_COMMENTS_SR")
public class CourseComments {

	@Id
	@Column(name = "CRS_CD")
	private String courseCode;

	@Column(name = "SEMESTER")
	private String semester;

	@Column(name = "CRS_COMMENTS1")
	private String commentOne;
	
	@Column(name = "CRS_COMMENTS2")
	private String commentTwo;
	
	@Column(name = "CRS_COMMENTS3")
	private String commentThree;
	
	@Column(name = "CRS_COMMENTS4")
	private String commentFour;
	
	@Column(name = "CRS_COMMENTS5")
	private String commentFive;
	
	public CourseComments() {}

	@Override
	public String toString() {
		return "CourseComments [courseCode=" + courseCode + ", semester=" + semester + ", commentOne=" + commentOne
				+ ", commentTwo=" + commentTwo + ", commentThree=" + commentThree + ", commentFour=" + commentFour
				+ ", commentFive=" + commentFive + "]";
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getCommentOne() {
		return commentOne;
	}

	public void setCommentOne(String commentOne) {
		this.commentOne = commentOne;
	}

	public String getCommentTwo() {
		return commentTwo;
	}

	public void setCommentTwo(String commentTwo) {
		this.commentTwo = commentTwo;
	}

	public String getCommentThree() {
		return commentThree;
	}

	public void setCommentThree(String commentThree) {
		this.commentThree = commentThree;
	}

	public String getCommentFour() {
		return commentFour;
	}

	public void setCommentFour(String commentFour) {
		this.commentFour = commentFour;
	}

	public String getCommentFive() {
		return commentFive;
	}

	public void setCommentFive(String commentFive) {
		this.commentFive = commentFive;
	}
}
