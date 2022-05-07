package com.awadhesh22791.springmvclearningcrm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.awadhesh22791.springmvclearningcrm.dao.CustomerDAO;
import com.awadhesh22791.springmvclearningcrm.dto.CustomerListSorting;
import com.awadhesh22791.springmvclearningcrm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(String name, CustomerListSorting sorting) {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = currentSession.getCriteriaBuilder();
		CriteriaQuery<Customer> selectQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = selectQuery.from(Customer.class);
		CriteriaQuery<Customer> select = selectQuery.select(root);
		if(name!=null && !name.isEmpty()) {
			select.where(criteriaBuilder.like(
					criteriaBuilder.lower(root.get("fullName")), name.toLowerCase()+"%"));
		}
		List<Order>ordering=new ArrayList<>();
		if(sorting.getSortByFirstName().equals(Boolean.TRUE)) {
			ordering.add(criteriaBuilder.desc(root.get("firstName")));
		} else {
			ordering.add(criteriaBuilder.asc(root.get("firstName")));
		}
		if(sorting.getSortByLastName().equals(Boolean.TRUE)) {
			ordering.add(criteriaBuilder.desc(root.get("lastName")));
		} else {
			ordering.add(criteriaBuilder.asc(root.get("lastName")));
		}
		if(sorting.getSortByEmail().equals(Boolean.TRUE)) {
			ordering.add(criteriaBuilder.desc(root.get("email")));
		} else {
			ordering.add(criteriaBuilder.asc(root.get("email")));
		}
		select.orderBy(ordering);
		Query<Customer> getQuery = currentSession.createQuery(selectQuery);//currentSession.createQuery("from Customer where fullName like :name order by firstName,lastName,email", Customer.class);
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
