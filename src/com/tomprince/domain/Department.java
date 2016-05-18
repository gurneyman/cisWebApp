package com.tomprince.domain;


import javax.persistence.*;

@Entity
@Table(name = "DEPT_SR")
public class Department {
	
	@Id
	@Column(name = "DEPT_ID")
	private String id;
	
	@Column(name = "DEPT_NAME")
	private String name;
	
	public Department() {}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
