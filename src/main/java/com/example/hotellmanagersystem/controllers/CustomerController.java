package com.example.hotellmanagersystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @PostMapping("/create")
    void createBokning(){

    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Long id){

    }

    @PutMapping("/update/{id}")
    void updateById(@PathVariable Long id){

    }

    @GetMapping("/all")
    void getAllRooms(){

    }
}
