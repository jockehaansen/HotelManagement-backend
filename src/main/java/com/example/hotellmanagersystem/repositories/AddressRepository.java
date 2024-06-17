package com.example.hotellmanagersystem.repositories;

import com.example.hotellmanagersystem.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    boolean existsByStreetAndCityAndZipCodeAndNumber(String street, String City, String zipCode, String number);
    Address findAddressByStreetAndCityAndZipCodeAndNumber(String street, String city, String zipCode, String number);
}
