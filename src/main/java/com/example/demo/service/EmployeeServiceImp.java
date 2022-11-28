package com.example.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService
{
	
	Logger log = LogManager.getLogger(EmployeeServiceImp.class);
	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployees() 
	{
		return repo.findAll();
	}

	@Override
	@Cacheable(cacheNames = "Employee", key = "#empId")
	public Employee getEmployee(int empId) 
	{
		log.info("inside get Employee");
		return repo.findById(empId).get();
	}

	@Override
	@CacheEvict(cacheNames = "Employee", key = "#empId")
	public void deleteEmployee(int empId) 
	{
		Employee emp = repo.findById(empId).get();
		if(emp != null)
		{
			repo.delete(emp);
		}
		System.out.println("Repo not found");
		
	}

	@Override
	@CachePut(cacheNames = "Employee", key = "#empId")
	public void updateEmployee(int empId, Employee employee) 
	{
		Employee emp = repo.findById(empId).get();
		if(emp!=null)
		{
			emp.setEmpName(employee.getEmpName());
			repo.save(emp);
		}
		System.out.println("Repo not found");
		
	}

	@Override
	public void insertEmployee(Employee employee) 
	{
		repo.save(employee);
	}

	

}
