package com.cs.h2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.cs.h2.entity.Test;

public class TestMapper implements RowMapper<Test> {

	public Test mapRow(ResultSet resultSet, int i) throws SQLException {

		Test test = new Test();

		test.setId(resultSet.getInt("id"));
		test.setName(resultSet.getString("name"));
		return test;
	}
}
