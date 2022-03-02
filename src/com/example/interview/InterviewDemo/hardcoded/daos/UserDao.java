package com.example.interview.InterviewDemo.hardcoded.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.interview.InterviewDemo.hardcoded.exceptions.UserNotFoundException;
import com.example.interview.InterviewDemo.hardcoded.models.User;

@Component
public class UserDao {
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == 0) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public Optional<User> findById(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst();
	}

	public boolean deleteById(int id) {
		if (users.stream().noneMatch(user -> user.getId() == id)) {
			throw new UserNotFoundException(String.format("user with id %d not found", id));
		}
		users = users.stream().filter(user -> user.getId() != id).collect(Collectors.toList());
		return true;
	}
}
