package com.cs.h2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.h2.jpa.entity.User;
import com.cs.h2.serviceimpl.UserRepo;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/create")
	public User createUser() {

		User user = new User(1, "user1");

		return userRepo.save(user);
	}

	@GetMapping("/all")
	public List<User> findAll() {

		return userRepo.findAll();
	}
	
	@GetMapping("/find")
	public List<User> findAllById() {
		
		List<Integer> ids = new ArrayList<>();
		ids.add(1);

		return userRepo.findAllById(ids);
	}

}
