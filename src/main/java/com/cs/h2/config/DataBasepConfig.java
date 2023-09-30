package com.cs.h2.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.cs.h2")
public class DataBasepConfig {

	@Autowired
	Environment environment;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String dbuser;

	@Value("${spring.datasource.password}")
	private String dbpassword;

	@Value("${spring.datasource.driverClassName}")
	private String driver;

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(dbuser);
		driverManagerDataSource.setPassword(dbpassword);
		driverManagerDataSource.setDriverClassName(driver);
		return driverManagerDataSource;
	}
}