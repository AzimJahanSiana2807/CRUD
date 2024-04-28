package com.assign.project.dao;

import java.util.*;

import com.assign.project.customer.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(String theId);

}

