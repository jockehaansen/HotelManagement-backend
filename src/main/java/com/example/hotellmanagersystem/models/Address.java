package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity(name = "customerAddress")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Street is required")
    @Size(max = 255, message = "Street cannot be longer than 255 characters")
    private String street;

    @NotBlank(message = "Number is required")
    @Size(max = 10, message = "Number cannot be longer than 10 characters")
    private String number;

    @NotBlank(message = "ZipCode is required")
    @Size(max = 10, message = "ZipCode cannot be longer than 10 characters")
    private String zipCode;

    @NotBlank(message = "City cannot be empty")
    @Size(max = 255, message = "City cannot be longer than 255 characters")
    private String city;

    @NotBlank(message = "Country cannot be empty")
    @Size(max = 255, message = "Country cannot be longer than 255 characters")
    private String country;

    private LocalDate created;
    private LocalDate lastUpdated;

    @OneToOne
    private User lastUpdatedBy;
}
