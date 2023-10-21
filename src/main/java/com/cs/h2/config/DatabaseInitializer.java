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

		String createEmployee = "create table employee (id int primary key , name varchar(30), email varchar(30))";

		String insertEmployee1 = "insert into employee (name, email) values (1,'Will Smith', 'will.smith@holywood.com')";

		String insertEmployee2 = "insert into employee (name, email) values (2,'Bill Gates', 'bill.gates@microsoft.com')";

		executeQuery(createEmployee);
		executeQuery(insertEmployee1);
		executeQuery(insertEmployee2);

	}

	public void executeQuery(String query) {
		try {
			jdbcTemplate.execute(query);
		} catch (Exception e) {
			logger.info("Error .." + e.getMessage());
		}
	}
}