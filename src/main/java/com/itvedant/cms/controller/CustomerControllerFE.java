package com.itvedant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.cms.entity.Customer;
import com.itvedant.cms.service.CustomerService;

@Controller
@RequestMapping("/cms/v1")
public class CustomerControllerFE {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/home")
	public String displayAllCustomers(Model model)
	{
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "customer-list";
	}
	
	@RequestMapping("/registerCustomer")
	public String registerCustomer(Model model)
	{
		Customer c=new Customer();
		model.addAttribute("mycust",c);
		return "register-customer-form";
	}
	
	@PostMapping("/addCustomerByRequestBody")
	public String addCustomer(@ModelAttribute Customer itvcustomer)
	{
		
		customerService.addCustomer(itvcustomer);
		return "redirect:/cms/v1/home";
	}
	

}
