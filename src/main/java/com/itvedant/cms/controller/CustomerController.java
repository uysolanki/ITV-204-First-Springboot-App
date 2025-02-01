package com.itvedant.cms.controller;

import java.security.Principal;
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
import org.springframework.web.servlet.ModelAndView;

import com.itvedant.cms.entity.Customer;
import com.itvedant.cms.service.CustomerService;

@RestController
//@RequestMapping("/cms/v1")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	@PostMapping("/addMultipleCustomers")
	public List<Customer> addMultipleCustomers(@RequestBody List<Customer> customers)
	{
		return customerService.addMultipleCustomers(customers);
	}
	
	
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/getCustomersByEmail/{emailId}")
	public List<Customer> getCustomersByEmail(@PathVariable("emailId") String email)
	{
		return customerService.getCustomersByEmail(email);
	}
	
	@GetMapping("/getCustomersByIdGreaterThan/{threshold}")
	public List<Customer> getCustomersByIdGreaterThan(@PathVariable("threshold") int threshold)
	{
		return customerService.getCustomersByIdGreaterThan(threshold);
	}
	
	@GetMapping("/getCustomer/{custid}")
	public Customer getCustomer(@PathVariable("custid") int custid)
	{
		return customerService.getCustomer(custid);
	}
	
	@DeleteMapping("/deleteCustomer/{custid}")
	public String deleteCustomer(@PathVariable("custid") int custid)
	{
		customerService.deleteCustomer(custid);
		return "Customer Record Deleted";
	}
	
	@PutMapping("/updateCustomer/{custid}")
	public Customer updateCustomer(@PathVariable("custid") int custid, @RequestBody Customer newCustomer)
	{
		return customerService.updateCustomer(custid,newCustomer);
	}	
	
//	@RequestMapping(value = "/403")
//	public String accesssDenied(Principal user) {
//			return "Hi " + user.getName() + "Forbidden";
//		
//	}
	

}
