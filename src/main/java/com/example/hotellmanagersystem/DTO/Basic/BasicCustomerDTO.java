package com.example.hotellmanagersystem.DTO.Basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicCustomerDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    //TODO private BasicAddressDTO address;
}
