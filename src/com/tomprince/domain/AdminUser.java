package com.tomprince.domain;

import javax.persistence.*;

@Entity
@Table(name = "ADMIN_USER_SR")
public class AdminUser {
	@Column(name = "ROLE")
	private String role;
	@Column(name = "SCHOOL")
	private String school;
	@Column(name = "DEPT")
	private String dept;
	
	@Id
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;

	public AdminUser() {}
	
	public AdminUser(String role, String school, String dept, String userName, String password) {
		this.role = role;
		this.school = school;
		this.dept = dept;
		this.userName = userName;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
