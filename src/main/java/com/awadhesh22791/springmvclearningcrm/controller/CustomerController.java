package com.awadhesh22791.springmvclearningcrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	final String CUSTOMERS_FOLDER="customers/";
	
	@GetMapping
	public String customers() {
		return CUSTOMERS_FOLDER+"home";
	}
}
