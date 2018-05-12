package com.javatechie.spring.cassandra.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.cassandra.api.model.User;
import com.javatechie.spring.cassandra.api.rpository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(6437, "Basant", "Bangalore", 50));
		users.add(new User(3523, "Saroj", "Pune", 20));
		users.add(new User(8694, "Ravindra", "Mumbai", 30));
		users.add(new User(9854, "Samas", "Odisha", 25));
		repository.saveAll(users);
	}

	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age) {
		return repository.findByAgeGreaterThan(age);
	}
}
