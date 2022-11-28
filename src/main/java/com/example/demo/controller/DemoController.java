package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class DemoController 
{
	Logger log = LogManager.getLogger(DemoController.class);
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/Employees")
	public List<Employee> getAllEmployees()
	{
		log.info("inside get All Employee");
		return service.getAllEmployees();
	}
	
	@GetMapping("/Employees/{empId}")
	public Employee getEmployee(@PathVariable("empId") int empId)
	{
		log.info("inside get Employee");
		return service.getEmployee(empId);
	}
	
	@DeleteMapping("/Employee/delete/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("empId") int empId)
	{
		log.info("inside Delete Employee");
		service.deleteEmployee(empId);
		return new ResponseEntity<>("Department Deleted", HttpStatus.GONE);
	}
	
	
	@PutMapping("/Employee/update/{empId}")
	public ResponseEntity<?> updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee employee)
	{
		log.info("inside Update Employee");
		service.updateEmployee(empId, employee);
		return new ResponseEntity<>("Department Updated", HttpStatus.CREATED);
	}
	
	@PostMapping("/Employee")
	public void insertEmployee(@RequestBody Employee employee)
	{
		log.info("inside Insert Employee");
		service.insertEmployee(employee);
		
	}
	
	
	
}