package com.itvedant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.cms.entity.Employee;
import com.itvedant.cms.service.EmployeeService;

@RestController
@RequestMapping("/cms/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee Employee)
	{
		return employeeService.addEmployee(Employee);
	}
	
	@DeleteMapping("/deleteEmployee/{eno}")
	public String deleteEmployee(@PathVariable("eno") int eno)
	{
		employeeService.deleteEmployee(eno);
		return "Record Deleted Successfully";
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/getEmployee/{eno}")
	public Employee getEmployee(@PathVariable("eno") int eno)
	{
		return employeeService.getEmployee(eno);
	}
	
}
