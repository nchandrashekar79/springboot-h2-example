package com.cs.h2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cs.h2.entity.Test;
import com.cs.h2.mapper.TestMapper;

@Repository
public class TestDaoImpl implements TestDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_FIND_TEST = "select * from TEST where id = ?";
	private final String SQL_DELETE_TEST = "delete from TEST where id = ?";
	private final String SQL_UPDATE_TEST = "update TEST set name = ? where id = ?";
	private final String SQL_GET_ALL = "select * from TEST";
	private final String SQL_INSERT_TEST = "insert into TEST(id, name) values(?,?)";

	public List<Test> getTest() {
		return jdbcTemplate.query(SQL_GET_ALL, new TestMapper());
	}
	
	public void createTest(Test test) {
		jdbcTemplate.update(SQL_INSERT_TEST,test.getId(), test.getName());
	}

	public List<Test> findOne(int id) {
		return jdbcTemplate.query(SQL_FIND_TEST, new TestMapper());
	}
	
	public void updateTest(Test test) {
		jdbcTemplate.update(SQL_UPDATE_TEST,test.getId(), test.getName());
	}
	
	public void deleteTest(int id) {
		jdbcTemplate.update(SQL_DELETE_TEST,id);
	}
}
