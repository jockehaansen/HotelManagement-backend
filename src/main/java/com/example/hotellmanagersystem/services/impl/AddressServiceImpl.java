package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.repositories.AddressRepository;
import com.example.hotellmanagersystem.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
}
