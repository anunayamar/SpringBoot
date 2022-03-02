package com.example.interview.InterviewDemo.hardcoded.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.InterviewDemo.hardcoded.exceptions.UserNotFoundException;
import com.example.interview.InterviewDemo.hardcoded.models.User;
import com.example.interview.InterviewDemo.hardcoded.services.UserService;

@RestController
public class UserController {
	//Field injection is discouraged, prefer constructor based injection. Since Spring 4, we don't need to specify @autowired during constructor injection
	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}

	@GetMapping(path = "/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name = "id") int userId) {
		Optional<User> user = userService.findAndGetUserById(userId);
		return ResponseEntity.ok(user.orElseThrow(() -> new UserNotFoundException(String.format("User with %d id not found", userId))));
	}

	//Note: it is a bad practice to receive and return model, instead should create UserWS
	//Ideally, should send status code 201 created instead of 200
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User createUser = userService.saveUser(user);
		return ResponseEntity.ok(createUser);
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "id") int userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
