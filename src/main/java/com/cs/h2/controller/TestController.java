package com.cs.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.h2.entity.Test;
import com.cs.h2.service.TestServiceImpl;

@RestController
public class TestController {
	
	@Autowired
	private TestServiceImpl service;
	
	@GetMapping("/test")
	public String test() {
		return "test..";
	}
	
	@GetMapping("/all")
	public List<Test> getAll() {
		return service.test();
	}
	
	@PostMapping("/create")
	public void create(@RequestBody Test test) {
		 service.createTest(test);
	}

}
