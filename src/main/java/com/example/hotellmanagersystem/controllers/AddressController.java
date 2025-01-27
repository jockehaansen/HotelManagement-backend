package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.dto.basic.BasicAddressDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.models.Address;
import com.example.hotellmanagersystem.services.AddressService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @Transactional
    @PostMapping("/create")
    public DetailedAddressDTO createAddress(@Valid @RequestBody DetailedAddressDTO address){
        return addressService.createAddress(address);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }

    @Transactional
    @PutMapping("/update")
    public DetailedAddressDTO updateAddress(@Valid @RequestBody DetailedAddressDTO address){
        return addressService.updateAddress(address);
    }

    @GetMapping("")
    List<DetailedAddressDTO> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/basic")
    List<BasicAddressDTO> getAllAddressesAsBasic(){
        return addressService.getAllAddressesAsBasicDTO();
    }

    @GetMapping("/basic/{id}")
    BasicAddressDTO getBasicAddress(@PathVariable Long id){
        return addressService.getBasicAddressDTOById(id);
    }

    @GetMapping("/detailed/{id}")
    DetailedAddressDTO getDetailedAddress(@PathVariable Long id){
        return addressService.getDetailedAddressDTOById(id);
    }
}
