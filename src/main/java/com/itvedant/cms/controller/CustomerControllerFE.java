package com.itvedant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itvedant.cms.entity.Customer;
import com.itvedant.cms.service.CustomerService;

@Controller
//@RequestMapping("/cms/v1")
public class CustomerControllerFE {
	
	@Autowired
	CustomerService customerService;
	
//	@GetMapping("/home")
//	public String displayAllCustomers(Model model)
//	{
//		List<Customer> customers=customerService.getAllCustomers();
//		model.addAttribute("customers",customers);
//		return "customer-list";
//	}
	
	@GetMapping("/home")
	public String displayAllCustomers(@RequestParam(name = "searchCustomerName", required = false, defaultValue = "") String searchString ,Model model)
	{
		List<Customer> customers;
		if(searchString.isEmpty())
		customers=customerService.getAllCustomers();
		else
		customers=customerService.getCustomersByName(searchString);
		
		model.addAttribute("customers",customers);
		model.addAttribute("searchCustomerName",searchString);
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
		return "redirect:/home";
	}
	
	@RequestMapping("/deleteCustomer/{custid}")
	public String deleteCustomer(@PathVariable("custid") int custid)
	{
		customerService.deleteCustomer(custid);
		return "redirect:/home";
	}
	
	@RequestMapping("/updateCustomerForm/{custid}")
	public String updateCustomerForm(@PathVariable("custid") int custid,Model model)
	{
		Customer customer=customerService.getCustomer(custid);
		model.addAttribute("customer",customer);
		return "update-customer-form";
	}
	
	@PostMapping("/updateCustomer/{id}")
	public String updateCustomer(@PathVariable("id") int custid,@ModelAttribute Customer customer)
	{
		customerService.updateCustomer(custid, customer);
		return "redirect:/home";
	}

}
