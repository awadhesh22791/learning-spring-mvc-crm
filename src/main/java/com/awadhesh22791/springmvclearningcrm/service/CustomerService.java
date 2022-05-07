package com.awadhesh22791.springmvclearningcrm.service;

import java.util.List;

import com.awadhesh22791.springmvclearningcrm.dto.CustomerListSorting;
import com.awadhesh22791.springmvclearningcrm.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers(String name, CustomerListSorting sorting);

	public void save(Customer customer);

	public Customer get(Integer id);

	public void update(Customer customer);

	public void delete(Integer id);
}
