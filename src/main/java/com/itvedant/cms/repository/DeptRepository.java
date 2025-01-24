package com.itvedant.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.cms.entity.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer>
{

}
