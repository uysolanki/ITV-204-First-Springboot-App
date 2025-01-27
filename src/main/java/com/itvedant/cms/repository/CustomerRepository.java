package com.itvedant.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itvedant.cms.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
	public List<Customer> findByCustEmailContaining(String z);
	
	//public List<Customer> findByCustIdGreaterThanEqual(int x);
	
	@Query(nativeQuery = true, value = "SELECT * FROM customer where custid>=?1 order by custname desc")
	public List<Customer> itvFindById(int x);
	
	
}
