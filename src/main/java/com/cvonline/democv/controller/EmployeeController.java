package com.cvonline.democv.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvonline.democv.pojo.Employee;

@RestController
public class EmployeeController {

	Map<Long, Employee> employeeDB = new HashMap<>();
	static Long employeeSNO = 1L;

	@GetMapping("/employees")
	Collection<Employee> all() {
		return employeeDB.values();
	}

	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		newEmployee.setId(employeeSNO);

		employeeDB.put(employeeSNO, newEmployee);
		employeeSNO++;
		return newEmployee;
	}

	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {
		return employeeDB.get(id);

	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		employeeDB.put(id, newEmployee);
		return newEmployee;
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		employeeDB.remove(id);
	}
}