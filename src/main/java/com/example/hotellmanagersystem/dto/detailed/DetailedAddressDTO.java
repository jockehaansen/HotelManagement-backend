package com.example.hotellmanagersystem.dto.detailed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedAddressDTO {
    private Long id;
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String country;
}
