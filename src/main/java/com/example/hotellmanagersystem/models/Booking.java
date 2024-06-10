package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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
    //denna ska auto-genereras i framtiden
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

    public Booking(LocalDate startDate, LocalDate endDate, double totalPrice, LocalDate created, Customer customer, List<Room> rooms){
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.created = created;
        this.customer = customer;
        this.rooms = rooms;
    }
}
