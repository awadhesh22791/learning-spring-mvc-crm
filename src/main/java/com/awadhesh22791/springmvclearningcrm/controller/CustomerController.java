package com.awadhesh22791.springmvclearningcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awadhesh22791.springmvclearningcrm.dao.CustomerDAO;
import com.awadhesh22791.springmvclearningcrm.entity.Customer;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/customers")
@Log4j2
public class CustomerController {

	final String CUSTOMERS_FOLDER="customers/";
	@Autowired
	private CustomerDAO customerDao;
	
	@GetMapping
	public String customers(Model model) {
		List<Customer> customers = customerDao.getCustomers();
		log.info("Found {} customers.",customers.size());
		model.addAttribute("customers", customers);
		return CUSTOMERS_FOLDER+"home";
	}
}
