package com.example.hotellmanagersystem.DTO.Detailed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedCustomerDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    //TODO private DetailedAddressDTO address;
    //TODO private List<DetailedBookingDTO> bookings;
}
