package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.services.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Transactional
    @PostMapping("/create")
    public DetailedCustomerDTO createCustomer(@Valid @RequestBody DetailedCustomerDTO customer){
        return customerService.createCustomer(customer);
    }

    @Transactional
    @DeleteMapping("/delete/{email}")
    public String deleteCustomerByEmail(@PathVariable String email){
        return customerService.deleteCustomerByEmail(email);
    }

    @Transactional
    @PutMapping("/update")
    public DetailedCustomerDTO updateCustomer(@Valid @RequestBody DetailedCustomerDTO customer){
        return customerService.updateCustomer(customer);
    }

    @GetMapping("")
    List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/basic")
    List<BasicCustomerDTO> getAllBasicCustomerDTOs(){
        return customerService.getAllCustomersAsBasicDTO();
    }

    @GetMapping("/detailed")
    List<DetailedCustomerDTO> getAllDetailedCustomerDTOs(){
        return customerService.getAllCustomersAsDetailedDTO();
    }

    @GetMapping("/customer/{email}")
    DetailedCustomerDTO getCustomer(@PathVariable String email){
        return customerService.getDetailedCustomerDTOByEmail(email);
    }

    @GetMapping("/customer/{email}/basic")
    BasicCustomerDTO getCustomerAsBasicDTO(@PathVariable String email){
        return customerService.getBasicCustomerDTOByEmail(email);
    }

    @GetMapping("/customer/{email}/detailed")
    DetailedCustomerDTO getCustomerAsDetailedDTO(@PathVariable String email){
        return customerService.getDetailedCustomerDTOByEmail(email);
    }
}
