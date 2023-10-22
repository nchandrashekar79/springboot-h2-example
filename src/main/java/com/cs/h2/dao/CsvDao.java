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

	private final String CSV_SQL_INSERT_TEST = "insert into Employee(fname, lname,designation,contact,sal,city) values(?,?,?,?,?,?)";

	public void save(Employee emp) {
		jdbcTemplate.update(CSV_SQL_INSERT_TEST, emp.firstName(), emp.lastName(),emp.designation(),emp.contact(),emp.sal(),emp.city());
	}

	public void saveAll(List<Employee> list) {

		for (Employee employee : list) {
			save(employee);
		}
	}

}
