package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.dto.basic.BasicAddressDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.models.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address updateAddress(DetailedAddressDTO address);
    String deleteAddressById(Long id);
    Address getAddressById(Long id);
    List<Address> getAllAddresses();

    //DTO HANDLING
    BasicAddressDTO getBasicAddressDTOById(Long id);
    DetailedAddressDTO getDetailedAddressDTOById(Long id);
    BasicAddressDTO addressToBasicAddressDTO(Address address);
    DetailedAddressDTO addressToDetailedAddressDTO(Address address);
    List<BasicAddressDTO> getAllAddressesAsBasicDTO();
    List<DetailedAddressDTO> getAllAddressesAsDetailedDTO();

    //UTILITY
    boolean isAddressFieldsValid(Address address);
    boolean isAddressAlreadyInDatabase(Address address);
}
