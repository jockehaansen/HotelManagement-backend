package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.models.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer();
    void updateCustomer();
    void deleteCustomer();
    List<Customer> getAllCustomers();
}
