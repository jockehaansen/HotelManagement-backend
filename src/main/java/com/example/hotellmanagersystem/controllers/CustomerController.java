package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.DTO.Basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/delete/{email}")
    String deleteByEmail(@PathVariable String email){
        return customerService.deleteCustomerByEmail(email);
    }

    @PutMapping("/update")
    Customer updateCustomer(@RequestBody Customer customer){
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
    Customer getCustomer(){
        return new Customer();
    }
}
