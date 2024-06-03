package com.example.hotellmanagersystem.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @PostMapping("/create")
    void createCustomer(){

    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Long id){

    }

    @PutMapping("/update/{id}")
    void updateById(@PathVariable Long id){

    }

    @GetMapping("")
    void getAllCustomers(){

    }
}
