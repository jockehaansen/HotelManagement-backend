package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.DTO.Basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    String deleteCustomerByEmail(String email);
    List<Customer> getAllCustomers();

    Customer getCustomerByEmail(String email);
    BasicCustomerDTO getBasicCustomerDTOByEmail(String email);
    DetailedCustomerDTO getDetailedCustomerDTOByEmail(String email);


    //DTO HANDLING
    BasicCustomerDTO customerToBasicCustomerDTO(Customer customer);
    DetailedCustomerDTO customerToDetailedCustomerDTO(Customer customer);

    List<BasicCustomerDTO> getAllCustomersAsBasicDTO();
    List<DetailedCustomerDTO> getAllCustomersAsDetailedDTO();
}
