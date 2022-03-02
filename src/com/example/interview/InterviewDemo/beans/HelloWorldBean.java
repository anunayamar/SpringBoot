package com.example.interview.InterviewDemo.beans;

public class HelloWorldBean {
	private String message;
	public HelloWorldBean(String message) {
		this.message = message;
	}

	//need getter for automatic conversion to json
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
