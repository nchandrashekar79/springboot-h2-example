package com.cs.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.h2.dao.TestDaoImpl;
import com.cs.h2.entity.Test;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDaoImpl dao;

	
	public List<Test> test() {
		return dao.getTest();
	}
	
	public void createTest(Test test) {
		 dao.createTest(test);
	}

	public void findOne(int id) {
		dao.findOne(id);
		
	}

	public void deleteTest(int id) {
		dao.deleteTest(id);
		
	}
	
}
