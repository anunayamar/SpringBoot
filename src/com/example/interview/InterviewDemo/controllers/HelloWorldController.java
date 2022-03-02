package com.example.interview.InterviewDemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.InterviewDemo.beans.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world/path-variable/{username}")
	public HelloWorldBean helloWorld(@PathVariable(name = "username") String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}
}
