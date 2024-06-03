package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    @ManyToOne()
    private Address address;

    @OneToMany
    private List<Booking> bookings;

    public Customer(String firstName, String lastName, String phoneNumber, String email, Address address, List<Booking> bookings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.bookings = bookings;
    }
}
