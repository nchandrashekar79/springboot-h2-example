package com.cs.h2.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.h2.controller.CsvReadController.Employee;
import com.cs.h2.dao.CsvDao;

@Service
public class CsvService {
	
	@Autowired
	private CsvDao csvDao;

	public void saveAll(List<Employee> list) {
		csvDao.saveAll(list);
	}

}
