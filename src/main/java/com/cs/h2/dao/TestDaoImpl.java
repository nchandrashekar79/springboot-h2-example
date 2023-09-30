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

	private final String SQL_FIND_PERSON = "select * from TEST where id = ?";
	private final String SQL_DELETE_PERSON = "delete from TEST where id = ?";
	private final String SQL_UPDATE_PERSON = "update TEST set name = ? where id = ?";
	private final String SQL_GET_ALL = "select * from TEST";
	private final String SQL_INSERT_PERSON = "insert into TEST(id, name) values(?,?)";

	public List<Test> getTest() {
		return jdbcTemplate.query(SQL_GET_ALL, new TestMapper());
	}
}
