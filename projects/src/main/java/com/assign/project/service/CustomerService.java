package com.assign.project.service;

import java.util.*;

import com.assign.project.customer.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(String theId);

}
