package com.cs.h2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
 
@Configuration
public class DatabaseInitializer {
 
    @Autowired JdbcTemplate jdbcTemplate;
     
    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {
             
            @Override
            public void run(String... args) throws Exception {
                 
                jdbcTemplate.execute("create table employees (id int primary key "
                        + "auto_increment, name varchar(30), email varchar(30))");
                 
                jdbcTemplate.execute("insert into employees (name, email) "
                        + "values ('Will Smith', 'will.smith@holywood.com')");
                 
                jdbcTemplate.execute("insert into employees (name, email) "
                        + "values ('Bill Gates', 'bill.gates@microsoft.com')");
                 
            }
        };
    }
}