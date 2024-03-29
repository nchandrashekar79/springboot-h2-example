package com.cs.h2.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	public DatabaseInitializer(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Database data initialize.");

		//String createEmployee = "create table employee (id int primary key , name varchar(30), email varchar(30))";
		
		//String createEmployee = "create table employee ( fname varchar(30), lname varchar(30))";
		
		
		
		String createEmployee2 = "create table employee ( fname varchar(30), lname varchar(30),designation varchar(30),contact varchar(30),sal varchar(30),city varchar(30))";
		
		String createUser = "create table user ( id INTEGER  PRIMARY KEY, name varchar(30))";

		executeQuery(createEmployee2);
		executeQuery(createUser);
		//executeQuery(insertEmployee2);
 
	}

	public void executeQuery(String query) {
		try {
			jdbcTemplate.execute(query);
		} catch (Exception e) {
			logger.info("Error .." + e.getCause());
		}
		finally {
			logger.info("final block ..");
		}
	}
}