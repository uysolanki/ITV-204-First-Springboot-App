package com.itvedant.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.cms.entity.Customer;
import com.itvedant.cms.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	public Customer getCustomer(int custid) {
		return customerRepository.findById(custid).get();
	}
	public void deleteCustomer(int custid) {
		customerRepository.deleteById(custid);
		
	}
	public Customer updateCustomer(int custid, Customer newCustomer) {
		Customer customerDb=getCustomer(custid);
		customerDb.setCustEmail(newCustomer.getCustEmail());
		customerDb.setCustMobile(newCustomer.getCustMobile());
		customerDb.setCustName(newCustomer.getCustName());
		return customerRepository.save(customerDb);
	}
	public List<Customer> addMultipleCustomers(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}

}
