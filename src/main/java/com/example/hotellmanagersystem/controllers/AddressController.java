package com.example.hotellmanagersystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
public class AddressController {

    @PostMapping("/create")
    void createAddress(){

    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Long id){

    }

    @PutMapping("/update/{id}")
    void updateById(@PathVariable Long id){

    }

    @GetMapping("")
    void getAllAddresses(){

    }
}
