package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.DTO.Basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.repositories.AddressRepository;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidCustomerAttributesException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidEmailException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        if (isCustomerFieldsValid(customer)){
            //TODO logic to check if the address already exists, and use that in that case instead of creating a new one
            addressRepository.save(customer.getAddress());
            return customerRepository.save(customer);
        } else {
            throw new InvalidCustomerAttributesException("Error, customer attributes not valid");
        }
    }

    @Transactional
    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO logic to validate the customer fields
        Customer customerToBeUpdated = customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(customer.getEmail())).findFirst()
                .orElseThrow(() -> new InvalidEmailException("Customer with email \" + email + \" was not found"));
        BeanUtils.copyProperties(customer, customerToBeUpdated, "id");
        customerRepository.save(customerToBeUpdated);
        return customerToBeUpdated;
    }

    @Transactional
    @Override
    public String deleteCustomerByEmail(String email) {
        //TODO logic to halt deletion if the customer has bookings
        Customer customer = customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .orElseThrow(() -> new InvalidIDException("Customer with email " + email + " was not found"));
        customerRepository.delete(customer);
        return "Customer with email " + email + " has been deleted successfully";
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmail() {
        return null;
    }

    @Override
    public BasicCustomerDTO getBasicCustomerDTOByEmail() {
        return null;
    }

    @Override
    public DetailedCustomerDTO getDetailedCustomerDTOByEmail() {
        return null;
    }

    //DTO HANDLING
    @Override
    public BasicCustomerDTO customerToBasicCustomerDTO(Customer customer) {
        return BasicCustomerDTO.builder().firstName(customer.getFirstName()).lastName(customer.getLastName()).phoneNumber(customer.getPhoneNumber()).email(customer.getEmail()).build();
    }

    @Override
    public DetailedCustomerDTO customerToDetailedCustomerDTO(Customer customer) {
        //TODO addressDTO och bookingDTO should be built in when made
        return DetailedCustomerDTO.builder().id(customer.getId()).firstName(customer.getFirstName()).lastName(customer.getLastName()).phoneNumber(customer.getPhoneNumber()).email(customer.getEmail()).build();
    }

    @Override
    public List<BasicCustomerDTO> getAllCustomersAsBasicDTO() {
        return customerRepository.findAll().stream().map(this::customerToBasicCustomerDTO).collect(Collectors.toList());
    }

    //UTILITY
    private boolean isCustomerFieldsValid(Customer customer){
        //TODO add logic to this function
        return true;
    }

    @Override
    public List<DetailedCustomerDTO> getAllCustomersAsDetailedDTO() {
        return customerRepository.findAll().stream().map(this::customerToDetailedCustomerDTO).collect(Collectors.toList());
    }
}
