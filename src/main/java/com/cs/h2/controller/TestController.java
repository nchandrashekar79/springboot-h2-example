package com.cs.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.h2.entity.Test;
import com.cs.h2.service.TestServiceImpl;

@RestController
@RequestMapping("test")
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
	
	@GetMapping("/find/{id}")
	public void findOne(@PathVariable("id") int id) {
		 service.findOne(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateTest(@RequestBody Test test,@PathVariable("id") int id) {
		 service.findOne(id);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteTest(@PathVariable("id") int id) {
		 service.deleteTest(id);
	}

}
