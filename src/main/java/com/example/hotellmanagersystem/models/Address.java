package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "customerAddress")
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
