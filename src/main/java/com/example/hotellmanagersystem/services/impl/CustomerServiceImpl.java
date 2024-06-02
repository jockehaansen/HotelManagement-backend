package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer() {

    }

    @Override
    public void updateCustomer() {

    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
