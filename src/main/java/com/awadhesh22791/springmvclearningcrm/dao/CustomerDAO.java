package com.awadhesh22791.springmvclearningcrm.dao;

import java.util.List;

import com.awadhesh22791.springmvclearningcrm.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers(String name);

	public void save(Customer customer);

	public Customer get(Integer id);

	public void update(Customer customer);

	public int delete(Integer id);
}
