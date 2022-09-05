package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpRepo repo;
	
	@GetMapping(path="/employees")
	public List<Employee> getEmployee(){
		
		return repo.findAll();
	}
	@PostMapping(path="/employee" , consumes= {"application/json"})
	public Employee addEmployee(@RequestBody Employee employee) {
		
		repo.save(employee);
		return employee;
	}
	@PutMapping(path="/employee",consumes= {"application/json"})
	public Employee updateEmployee (@RequestBody Employee employee){
		repo.save(employee);
		return employee;
	}
	@DeleteMapping("/employee/{empid}")
	public String deleteEmployee(@PathVariable int empid) {
		Employee e = repo.getOne(empid);
		repo.delete(e);
		
		return "Your delete operation has been successfully performed";
	}
	}


