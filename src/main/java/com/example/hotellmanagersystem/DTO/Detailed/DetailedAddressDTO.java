package com.example.hotellmanagersystem.DTO.Detailed;

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
    private String streetName;
    private String number;
    private String postCode;
    private String state;
    private String country;
}
