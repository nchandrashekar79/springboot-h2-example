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
		try {

		jdbcTemplate.execute(
				"create table employees (id int primary key " + "auto_increment, name varchar(30), email varchar(30))");

		jdbcTemplate
				.execute("insert into employees (name, email) " + "values ('Will Smith', 'will.smith@holywood.com')");

		jdbcTemplate
				.execute("insert into employees (name, email) " + "values ('Bill Gates', 'bill.gates@microsoft.com')");

	}

	catch(Exception e) {
		logger.info("Error .."+e.getMessage());
	}
	}
}