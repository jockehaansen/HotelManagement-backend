package com.example.hotellmanagersystem.dto.basic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicAddressDTO {

    @NotBlank(message = "Street is required")
    @Size(max = 255, message = "Street cannot be longer than 255 characters")
    private String street;

    @NotBlank(message = "Number is required")
    @Size(max = 10, message = "Number cannot be longer than 10 characters")
    private String number;

    @NotBlank(message = "ZipCode is required")
    @Size(max = 10, message = "ZipCode cannot be longer than 10 characters")
    private String zipCode;

    @NotBlank(message = "City is required")
    @Size(max = 255, message = "City cannot be longer than 255 characters")
    private String city;

    @NotBlank(message = "Country is required")
    @Size(max = 255, message = "Country cannot be longer than 255 characters")
    private String country;
}
