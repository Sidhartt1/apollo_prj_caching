package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService 
{

	List<Employee> getAllEmployees();

	Employee getEmployee(int empId);

	void deleteEmployee(int empId);

	void updateEmployee(int empId, Employee employee);

	void insertEmployee(Employee employee);

	
	
}
