package com.awadhesh22791.springmvclearningcrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.awadhesh22791.springmvclearningcrm.dao.CustomerDAO;
import com.awadhesh22791.springmvclearningcrm.entity.Customer;
import com.awadhesh22791.springmvclearningcrm.service.CustomerService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomers(String name) {
		return customerDao.getCustomers(name);
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	@Transactional
	public Customer get(Integer id) {
		return customerDao.get(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Customer customer) {
		Customer existingCustomer = get(customer.getId());
		existingCustomer.prepareToUpdate(customer);
		customerDao.update(existingCustomer);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id) {
		int rowsDeleted = customerDao.delete(id);
		log.info("Deleted {} customers.",rowsDeleted);
	}

}
