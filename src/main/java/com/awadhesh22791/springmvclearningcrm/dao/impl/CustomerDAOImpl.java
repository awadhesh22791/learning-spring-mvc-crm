package com.awadhesh22791.springmvclearningcrm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.awadhesh22791.springmvclearningcrm.dao.CustomerDAO;
import com.awadhesh22791.springmvclearningcrm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> getQuery = currentSession.createQuery("from Customer order by firstName,lastName,email", Customer.class);
		return getQuery.getResultList();
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	}

	@Override
	public Customer get(Integer id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public void update(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public int delete(Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("delete from Customer where id=:id").setParameter("id", id).executeUpdate();
	}

}
