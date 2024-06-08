package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    private Long bookingNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private LocalDate created;
    private LocalDate lastUpdated;

    @ManyToOne
    private User updatedBy;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Room> rooms;
}
