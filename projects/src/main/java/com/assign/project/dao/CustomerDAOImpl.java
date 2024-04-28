package com.assign.project.dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.assign.project.customer.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save or update theCustomer
		
		currentSession.saveOrUpdate(theCustomer);
	}
	@Override
	public Customer getCustomer(String theId) {
		// TODO Auto-generated method stub

		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

}
