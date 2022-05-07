package com.awadhesh22791.springmvclearningcrm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.awadhesh22791.springmvclearningcrm.entity.Customer;
import com.awadhesh22791.springmvclearningcrm.service.CustomerService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("customers")
@Log4j2
public class CustomerController {

	final String CUSTOMERS_FOLDER = "customers/";
	@Autowired
	private CustomerService customerService;

	@GetMapping("list")
	public String customers(Model model,@RequestParam(name = "name",required = false)String name) {
		List<Customer> customers = customerService.getAllCustomers(name);
		log.info("Found {} customers.", customers.size());
		model.addAttribute("customers", customers);
		return CUSTOMERS_FOLDER + "list";
	}

	@GetMapping("new")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return CUSTOMERS_FOLDER + "new";
	}

	@PostMapping("save")
	public String save(@Valid @ModelAttribute Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return CUSTOMERS_FOLDER + "new";
		} else {
			customerService.save(customer);
			return "redirect:"+"list";
		}
	}
	
	@GetMapping("edit")
	public String edit(@RequestParam("id")Integer id,Model model) {
		model.addAttribute("customer", customerService.get(id));
		return CUSTOMERS_FOLDER+"edit";
	}
	
	@PostMapping("update")
	public String update(@Valid @ModelAttribute Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return CUSTOMERS_FOLDER + "update";
		} else {
			customerService.update(customer);
			return "redirect:"+"list";
		}
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("id")Integer id) {
		customerService.delete(id);
		return "redirect:"+"list";
	}
}
