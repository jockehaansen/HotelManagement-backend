package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.repositories.AddressRepository;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidCustomerAttributesException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidEmailException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public Customer createCustomer(Customer customer) {
        if (isCustomerFieldsValid(customer)){
            //TODO logic to check if the address already exists, and use that in that case instead of creating a new one
            addressRepository.save(customer.getAddress());
            return customerRepository.save(customer);
        } else throw new InvalidCustomerAttributesException("Error, customer attributes not valid");
    }

    @Transactional
    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO logic to validate the incoming customer fields
        Customer customerToBeUpdated = customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(customer.getEmail())).findFirst()
                .orElseThrow(() -> new InvalidEmailException("Customer with email \" + email + \" was not found"));
        BeanUtils.copyProperties(customer, customerToBeUpdated, "id, created");
        return customerRepository.save(customerToBeUpdated);
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
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .orElseThrow(() -> new InvalidEmailException("Customer with email " + email + " was not found"));
    }

    @Override
    public BasicCustomerDTO getBasicCustomerDTOByEmail(String email) {
        return customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .map(this::customerToBasicCustomerDTO).orElseThrow(() -> new InvalidEmailException("Customer with email " + email + " was not found"));
    }

    @Override
    public DetailedCustomerDTO getDetailedCustomerDTOByEmail(String email) {
        return customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .map(this::customerToDetailedCustomerDTO).orElseThrow(() -> new InvalidEmailException("Customer with email " + email + " was not found"));
    }

    //DTO HANDLING
    @Override
    public BasicCustomerDTO customerToBasicCustomerDTO(Customer customer) {
        return modelMapper.map(customer, BasicCustomerDTO.class);
    }

    @Override
    public DetailedCustomerDTO customerToDetailedCustomerDTO(Customer customer) {
        return modelMapper.map(customer, DetailedCustomerDTO.class);
    }

    @Override
    public List<BasicCustomerDTO> getAllCustomersAsBasicDTO() {
        return customerRepository.findAll().stream().map(this::customerToBasicCustomerDTO).toList();
    }

    @Override
    public List<DetailedCustomerDTO> getAllCustomersAsDetailedDTO() {
        return customerRepository.findAll().stream().map(this::customerToDetailedCustomerDTO).toList();
    }

    //UTILITY
    @Override
    public boolean isCustomerFieldsValid(Customer customer){
        //TODO add logic to this function
        return true;
    }

    private void validatePhoneNumber(){
        //TODO create logic
    }

    private void validateEmail(){
        //TODO create logic
    }

}
