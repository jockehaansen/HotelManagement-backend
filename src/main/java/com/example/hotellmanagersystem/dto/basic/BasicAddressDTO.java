package com.example.hotellmanagersystem.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicAddressDTO {
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String country;
}
