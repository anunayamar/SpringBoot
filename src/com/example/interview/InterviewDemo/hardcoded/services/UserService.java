package com.example.interview.InterviewDemo.hardcoded.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.interview.InterviewDemo.hardcoded.daos.UserDao;
import com.example.interview.InterviewDemo.hardcoded.models.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> getUsers() {
		return userDao.findAll();
	}

	public Optional<User> findAndGetUserById(int id) {
		return userDao.findById(id);
	}

	public User saveUser(User user) {
		return userDao.save(user);
	}

	public boolean deleteUser(int userId) {
		return userDao.deleteById(userId);
	}
}
