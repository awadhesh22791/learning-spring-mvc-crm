package com.awadhesh22791.springmvclearningcrm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.awadhesh22791.springmvclearningcrm.dao.CustomerDAO;
import com.awadhesh22791.springmvclearningcrm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> getQuery = currentSession.createQuery("from Customer", Customer.class);
		return getQuery.getResultList();
	}

}
