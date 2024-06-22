package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedAddressDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedCustomerDTO;
import com.example.hotellmanagersystem.models.Address;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.repositories.AddressRepository;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.utilities.configs.MapperConfig;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidEmailException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper = MapperConfig.modelMapper();

    @Override
    public DetailedCustomerDTO createCustomer(DetailedCustomerDTO customer) {
        Customer customerToBeCreated = new Customer();
        customerToBeCreated.setCreated(LocalDate.now());
        checkAndSetCustomerAddress(customer, customerToBeCreated);
        return customerToDetailedCustomerDTO(customerRepository.save(setCustomerAttributes(customer, customerToBeCreated)));
    }

    @Transactional
    @Override
    public DetailedCustomerDTO updateCustomer(DetailedCustomerDTO customer) {
        Customer customerToBeUpdated = customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(customer.getEmail())).findFirst()
                .orElseThrow(() -> new InvalidEmailException("Customer with email \" + email + \" was not found"));
        return customerToDetailedCustomerDTO(customerRepository.save(setCustomerAttributes(customer, customerToBeUpdated)));
    }

    @Transactional
    @Override
    public String deleteCustomerByEmail(String email) {
        //TODO logic to halt deletion if the customer has bookings
        Customer customer = customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .orElseThrow(() -> new InvalidIDException("Customer with email " + email + " was not found"));
        customerRepository.delete(customer);
        return "Customer with email " + email + " has been deleted successfully";
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .orElseThrow(() -> new InvalidEmailException("Customer with email " + email + " was not found"));
    }

    @Override
    public BasicCustomerDTO getBasicCustomerDTOByEmail(String email) {
        return customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .map(this::customerToBasicCustomerDTO).orElseThrow(() -> new InvalidEmailException("Customer with email " + email + " was not found"));
    }

    @Override
    public DetailedCustomerDTO getDetailedCustomerDTOByEmail(String email) {
        return customerRepository.findAll().stream().filter(c -> c.getEmail().equalsIgnoreCase(email)).findFirst()
                .map(this::customerToDetailedCustomerDTO).orElseThrow(() -> new InvalidEmailException("Customer with email " + email + " was not found"));
    }

    //DTO HANDLING
    @Override
    public BasicCustomerDTO customerToBasicCustomerDTO(Customer customer) {
        return modelMapper.map(customer, BasicCustomerDTO.class);
    }

    @Override
    public DetailedCustomerDTO customerToDetailedCustomerDTO(Customer customer) {
        DetailedCustomerDTO detailedCustomerDTO = modelMapper.map(customer, DetailedCustomerDTO.class);

        return detailedCustomerDTO;
    }

    @Override
    public List<BasicCustomerDTO> getAllCustomersAsBasicDTO() {
        return customerRepository.findAll().stream().map(this::customerToBasicCustomerDTO).toList();
    }

    @Override
    public List<DetailedCustomerDTO> getAllCustomersAsDetailedDTO() {
        return customerRepository.findAll().stream().map(this::customerToDetailedCustomerDTO).toList();
    }


    //UTILITY
    @Override
    public Customer setCustomerAttributes(DetailedCustomerDTO customerDTO, Customer customer) {
        BeanUtils.copyProperties(customerDTO, customer,"id", "created");
        customer.setLastUpdated(LocalDate.now());
        return customer;
    }

    public void checkAndSetCustomerAddress(DetailedCustomerDTO customer, Customer customerToBeCreated ){
        DetailedAddressDTO addressToCheck = customer.getAddress();

        if (addressRepository.existsByStreetAndCityAndZipCodeAndNumber(addressToCheck.getStreet(),
                addressToCheck.getCity(), addressToCheck.getZipCode(), addressToCheck.getNumber())){
            Address foundAddress = addressRepository.findAddressByStreetAndCityAndZipCodeAndNumber(addressToCheck.getStreet(), addressToCheck.getCity(),
                    addressToCheck.getZipCode(), addressToCheck.getNumber());
            customerToBeCreated.setAddress(foundAddress);
        } else {
            Address addressToBeCreated = new Address();
            addressToBeCreated.setCreated(LocalDate.now());
            BeanUtils.copyProperties(addressToCheck,  addressToBeCreated, "id", "created");
            addressRepository.save(addressToBeCreated);
            customerToBeCreated.setAddress(addressToBeCreated);
        }
    }
}
