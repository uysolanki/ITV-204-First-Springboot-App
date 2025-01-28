package com.itvedant.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms/v1")
public class CustomerControllerFE {
	
	@GetMapping("/welcomefe")
	public String welcome()
	{
		return "welcome";
	}

}
