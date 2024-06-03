package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "customerAddress")
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String streetName;
    private String number;
    private String postCode;
    private String state;
    private String country;

}
