package com.itvedant.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.cms.entity.Dept;
import com.itvedant.cms.repository.DeptRepository;

@Service
public class DeptService {

	@Autowired
	DeptRepository deptRepo;
	
	public Dept addDept(Dept dept)
	{
		return deptRepo.save(dept);
	}

	public Dept abc(Dept dept) {
		return deptRepo.save(dept);
	}

	public void deleteDept(int dno) {
		deptRepo.deleteById(dno);
	}

	public List<Dept> getAllDept() {
		return deptRepo.findAll();
	}

	public Dept getDept(int dno) {
		return deptRepo.findById(dno).get();
	}

	

	
}
