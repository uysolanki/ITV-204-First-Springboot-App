package com.itvedant.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.cms.entity.Employee;
import com.itvedant.cms.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository  employeeRepository;
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	public void deleteEmployee(int eno) {
		employeeRepository.deleteById(eno);	
	}
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	public Employee getEmployee(int eno) {
		return employeeRepository.findById(eno).get();
	}

}
