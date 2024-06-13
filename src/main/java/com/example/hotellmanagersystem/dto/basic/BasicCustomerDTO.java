package com.example.hotellmanagersystem.dto.basic;

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
    private BasicAddressDTO address;
}
