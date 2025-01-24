package com.itvedant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.cms.entity.Customer;
import com.itvedant.cms.entity.Dept;
import com.itvedant.cms.service.DeptService;

@RestController
@RequestMapping("/cms/v1")
public class DeptController {
	@Autowired
	DeptService deptService;
	
	@PostMapping("/addDept")
	public Dept addDept(@RequestBody Dept dept)
	{
		return deptService.abc(dept);
	}
	
	@DeleteMapping("/deleteDept/{dno}")
	public String deleteDept(@PathVariable("dno") int dno)
	{
		deptService.deleteDept(dno);
		return "Record Deleted Successfully";
	}
	
	@GetMapping("/getAllDept")
	public List<Dept> getAllDept()
	{
		return deptService.getAllDept();
	}
	
	@GetMapping("/getDept/{dno}")
	public Dept getDept(@PathVariable("dno") int dno)
	{
		return deptService.getDept(dno);
	}
	

}
