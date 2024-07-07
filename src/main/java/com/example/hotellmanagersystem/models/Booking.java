package com.example.hotellmanagersystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Booking number is required")
    private Long bookingNumber;

    @NotNull(message = "StartDate is required")
    @Basic
    private LocalDate startDate;

    @NotNull(message = "EndDate is required")
    @Basic
    private LocalDate endDate;

    @NotNull(message = "TotalPrice is required")
    private double totalPrice;

    @NotNull(message = "Created is required")
    @Basic
    private LocalDate created;

    @Basic
    private LocalDate lastUpdated;

    @ManyToOne
    //TODO JOINCOLUMN?
    private User lastUpdatedBy;

    @ManyToOne
    @NotNull(message = "Customer is required")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @NotNull(message = "Room is required")
    private Room room;

    public Booking(Long bookingNumber, LocalDate startDate, LocalDate endDate, double totalPrice, LocalDate created, Customer customer, Room room){
        this.bookingNumber = bookingNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.created = created;
        this.customer = customer;
        this.room = room;
    }
}
