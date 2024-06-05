package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.DTO.Basic.BasicAddressDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    Address updateAddress(Address address);
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
}
