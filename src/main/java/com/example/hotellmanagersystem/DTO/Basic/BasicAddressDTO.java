package com.example.hotellmanagersystem.DTO.Basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicAddressDTO {
    private String streetName;
    private String number;
    private String postCode;
}
