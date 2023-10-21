package com.cs.h2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cs.h2.controller.CsvReadController.Employee;
import com.cs.h2.entity.Test;

@Repository
public class CsvDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT_TEST = "insert into Employee(id, name) values(?,?)";
	
	public void save(Test test) {
		jdbcTemplate.update(SQL_INSERT_TEST,test.getId(), test.getName());
	}

	public void saveAll(List<Employee> list) {
		
	}

}
