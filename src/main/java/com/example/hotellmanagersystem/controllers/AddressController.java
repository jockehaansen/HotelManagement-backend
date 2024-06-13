package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.dto.basic.BasicAddressDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.models.Address;
import com.example.hotellmanagersystem.services.AddressService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidAddressAttributesException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    Address createAddress(@Valid @RequestBody Address address, BindingResult result){
        if (result.hasErrors()){
            throw new InvalidAddressAttributesException(result.getAllErrors().toString());
        }
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
