package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
