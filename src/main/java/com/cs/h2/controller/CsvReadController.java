package com.cs.h2.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.h2.service.CsvService;

@RestController
@RequestMapping("csvreader")
public class CsvReadController {
	
	@Autowired
	private CsvService csvReadService;

	@GetMapping("/load")
	public String test() throws FileNotFoundException, IOException {
		loadData();
		return "load..";
	}

	public record Employee(String firstName, String lastName) {
	}

	// First Name ,Last Name,Designation,Contact,Sal,City

	public void loadData() throws FileNotFoundException, IOException {
		String path = "C:\\Users\\Admin\\temp\\Book1.csv";

		List<Employee> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				list.add(new Employee(values[0], values[1]));
			}
		}

		csvReadService.saveAll(list);

		list.forEach(System.out::println);
	}
}
