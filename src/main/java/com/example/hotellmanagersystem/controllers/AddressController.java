package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.DTO.Basic.BasicAddressDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.models.Address;
import com.example.hotellmanagersystem.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @DeleteMapping("/delete/{id}")
    String deleteById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }

    @PutMapping("/update")
    Address updateAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @GetMapping("")
    List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/basic")
    List<BasicAddressDTO> getAllAddressesAsBasicDTOs(){
        return addressService.getAllAddressesAsBasicDTO();
    }

    @GetMapping("/detailed")
    List<DetailedAddressDTO> getAllAddressesAsDetailedDTOs(){
        return addressService.getAllAddressesAsDetailedDTO();
    }

    @GetMapping("/basic/{id}")
    BasicAddressDTO getAddressAsBasicDTO(@PathVariable Long id){
        return addressService.getBasicAddressDTOById(id);
    }

    @GetMapping("/detailed/{id}")
    DetailedAddressDTO getAddressAsDetailedDTO(@PathVariable Long id){
        return addressService.getDetailedAddressDTOById(id);
    }
}
