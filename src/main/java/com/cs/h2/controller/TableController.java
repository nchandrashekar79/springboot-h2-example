package com.cs.h2.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.TableService;

@RestController
@RequestMapping("/tables")
public class TableController {

	@Autowired
	private TableService tableService;

	@GetMapping("/{tableName}")
	public ResponseEntity<List<Map<String, Object>>> getTableData(@PathVariable String tableName) {
		List<Map<String, Object>> data = tableService.getTableData(tableName);
		return ResponseEntity.ok(data);
	}

	@GetMapping("/all")
	public List<Map<String, Object>> getTableNames() {
		return tableService.getTableNames();
	}
}
