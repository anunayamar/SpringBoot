package com.example.interview.InterviewDemo.hardcoded.models;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private Integer id;

	@Size(min = 3, message = "name should be at least 3 characters")
	private String name;

	@Past(message = "date should be in past")
	private Date date;

	public User(int id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", date=" + date +
				'}';
	}
}
