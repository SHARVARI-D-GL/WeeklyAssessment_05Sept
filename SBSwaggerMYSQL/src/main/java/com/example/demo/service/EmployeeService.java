package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public String saveemployee(Employee emp)
	{
		employeeRepository.save(emp);
		return "Employee Infor saved sucessfully";
			
	}
	public List<Employee> getallemployees()
	{
		return employeeRepository.findAll();
		
	}


	public void deleteemployee(int id)
	{
		employeeRepository.deleteById(id); 
	}
	public Employee updateemployee(int id)
	{
		return employeeRepository.getOne(id);
	}
}
