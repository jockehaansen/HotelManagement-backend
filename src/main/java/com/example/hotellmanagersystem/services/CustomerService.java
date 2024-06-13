package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    String deleteCustomerByEmail(String email);
    Customer getCustomerByEmail(String email);
    List<Customer> getAllCustomers();

    //DTO HANDLING
    BasicCustomerDTO getBasicCustomerDTOByEmail(String email);
    DetailedCustomerDTO getDetailedCustomerDTOByEmail(String email);
    BasicCustomerDTO customerToBasicCustomerDTO(Customer customer);
    DetailedCustomerDTO customerToDetailedCustomerDTO(Customer customer);
    List<BasicCustomerDTO> getAllCustomersAsBasicDTO();
    List<DetailedCustomerDTO> getAllCustomersAsDetailedDTO();

    //UTILITY
    boolean isCustomerFieldsValid(Customer customer);
}
