package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.dto.basic.BasicAddressDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.models.Address;

import java.util.List;

public interface AddressService {
    DetailedAddressDTO createAddress(DetailedAddressDTO address);
    DetailedAddressDTO updateAddress(DetailedAddressDTO address);
    String deleteAddressById(Long id);
    Address getAddressById(Long id);
    List<DetailedAddressDTO> getAllAddresses();

    //DTO HANDLING
    BasicAddressDTO getBasicAddressDTOById(Long id);
    DetailedAddressDTO getDetailedAddressDTOById(Long id);
    BasicAddressDTO addressToBasicAddressDTO(Address address);
    DetailedAddressDTO addressToDetailedAddressDTO(Address address);
    List<BasicAddressDTO> getAllAddressesAsBasicDTO();
    List<DetailedAddressDTO> getAllAddressesAsDetailedDTO();

    //UTILITY
    boolean isAddressAlreadyInDatabase(Address address);
    Address setAddressAttributes(DetailedAddressDTO addressDTO, Address address);
}
