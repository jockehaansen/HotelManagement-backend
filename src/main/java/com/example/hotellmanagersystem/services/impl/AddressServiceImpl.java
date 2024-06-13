package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.basic.BasicAddressDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.models.Address;
import com.example.hotellmanagersystem.repositories.AddressRepository;
import com.example.hotellmanagersystem.services.AddressService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.EntityAlreadyExistsException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidAddressAttributesException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public Address createAddress(Address address) {
        if (isAddressAlreadyInDatabase(address)){
            throw new EntityAlreadyExistsException("Error, address already exist. No new address was created");
        } else if (isAddressFieldsValid(address)){
            return addressRepository.save(address);
        } else throw new InvalidAddressAttributesException("Error, address attributes not valid");
    }

    @Override
    public Address updateAddress(Address address) {
        //TODO logic to validate the incoming address fields
        Address addressToBeUpdated = addressRepository.findById(address.getId())
                .orElseThrow(() -> new InvalidIDException("Error, address with id " + address.getId() + " was not found"));
        BeanUtils.copyProperties(address, addressToBeUpdated, "id, created");
        //TODO implement and set updated
        return addressRepository.save(address);
    }

    @Override
    public String deleteAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new InvalidIDException("Error, address with id " + id + " was not found"));
        addressRepository.delete(address);
        return "Address with id " + id + " has been deleted successfully";
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new InvalidIDException("Error, address with id" + id + " was not found"));
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    //DTO HANDLING
    @Override
    public BasicAddressDTO getBasicAddressDTOById(Long id) {
        return addressRepository.findById(id).map(this::addressToBasicAddressDTO).orElseThrow(() -> new InvalidIDException("Error, address with id " + id + " was not found"));
    }

    @Override
    public DetailedAddressDTO getDetailedAddressDTOById(Long id) {
        return addressRepository.findById(id).map(this::addressToDetailedAddressDTO).orElseThrow(() -> new InvalidIDException("Error, address with id " + id + " was not found"));
    }

    @Override
    public BasicAddressDTO addressToBasicAddressDTO(Address address) {
        return modelMapper.map(address, BasicAddressDTO.class);
    }

    @Override
    public DetailedAddressDTO addressToDetailedAddressDTO(Address address) {
        return modelMapper.map(address, DetailedAddressDTO.class);
    }

    @Override
    public List<BasicAddressDTO> getAllAddressesAsBasicDTO() {
        return addressRepository.findAll().stream().map(this::addressToBasicAddressDTO).toList();
    }

    @Override
    public List<DetailedAddressDTO> getAllAddressesAsDetailedDTO() {
        return addressRepository.findAll().stream().map(this::addressToDetailedAddressDTO).toList();
    }

    //UTILITY
    @Override
    public boolean isAddressFieldsValid(Address address) {
        //TODO logic to check the address fields are valid
        return true;
    }

    @Override
    public boolean isAddressAlreadyInDatabase(Address address){
        return addressRepository.existsByStreetAndCityAndZipCodeAndNumber(address.getStreet(), address.getCity(), address.getZipCode(), address.getNumber());
    }
}
