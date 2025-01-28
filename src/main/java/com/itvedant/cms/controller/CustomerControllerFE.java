package com.itvedant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.cms.entity.Customer;
import com.itvedant.cms.service.CustomerService;

@Controller
@RequestMapping("/cms/v1")
public class CustomerControllerFE {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/welcomefe")
	public String welcome(Model model)
	{
		String s1="Rohit Sharma";
		Customer customer =new Customer();
		customer.setCustEmail("alice@gmail.com");
		customer.setCustId(101);
		customer.setCustMobile("9890123123");
		customer.setCustName("Alice");
		
		model.addAttribute("c1",customer);
		return "welcome";
	}
	
	@GetMapping("/displayAllCustomers")
	public String displayAllCustomers(Model model)
	{
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "customer-list";
	}

}
