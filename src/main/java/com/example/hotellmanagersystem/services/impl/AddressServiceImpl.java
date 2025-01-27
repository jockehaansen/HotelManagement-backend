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

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public DetailedAddressDTO createAddress(DetailedAddressDTO address) {
        Address addressToBeCreated = new Address();
        addressToBeCreated.setCreated(LocalDate.now());
        setAddressAttributes(address, addressToBeCreated);

        if (isAddressAlreadyInDatabase(addressToBeCreated)){
            throw new EntityAlreadyExistsException("Error, address already exist. No new address was created");
        }
        return addressToDetailedAddressDTO(addressRepository.save(addressToBeCreated));
    }

    @Override
    public DetailedAddressDTO updateAddress(DetailedAddressDTO address) {
        Address addressToBeUpdated = addressRepository.findById(address.getId())
                .orElseThrow(() -> new InvalidIDException("Error, address with id " + address.getId() + " was not found"));
        return addressToDetailedAddressDTO(addressRepository.save(setAddressAttributes(address, addressToBeUpdated)));
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
    public List<DetailedAddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream().map(this::addressToDetailedAddressDTO).toList();
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
    public boolean isAddressAlreadyInDatabase(Address address){
        return addressRepository.existsByStreetAndCityAndZipCodeAndNumber(address.getStreet(), address.getCity(),
                address.getZipCode(), address.getNumber());
    }

    @Override
    public Address setAddressAttributes(DetailedAddressDTO addressDTO, Address address) {
        BeanUtils.copyProperties(addressDTO, address, "id", "created");
        address.setLastUpdated(LocalDate.now());
        return address;
    }
}
