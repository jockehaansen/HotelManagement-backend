package com.example.hotellmanagersystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "Firstname is required")
    @Size(max = 255, message = "Firstname cannot be longer than 255 characters")
    private String firstName;

    @NotEmpty(message = "Lastname is required")
    @Size(max = 255, message = "Lastname cannot be longer than 255 characters")
    private String lastName;

    @NotEmpty(message = "Phone number is required")
    @Size(min=10, max = 17, message = "Phone number has to be between 10 and 17 numbers")
    private String phoneNumber;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    @ManyToOne()
    @NotEmpty(message = "Address is required")
    private Address address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
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
