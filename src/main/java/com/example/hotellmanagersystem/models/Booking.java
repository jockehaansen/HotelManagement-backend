package com.example.hotellmanagersystem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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

    @NotNull(message = "Guests is required")
    @Min(value = 1, message = "Guests cannot be less than 1")
    @Max(value = 4, message = "Guests cannot be more than 4")
    private int guests;

    @Basic
    private LocalDate lastUpdated;

    @ManyToOne
    private User lastUpdatedBy;

    @ManyToOne
    @NotNull(message = "Customer is required")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @NotNull(message = "Room is required")
    private Room room;

    @PrePersist
    protected void onCreate(){
        this.created = LocalDate.now();
    }

    public Booking(Long bookingNumber, LocalDate startDate, LocalDate endDate, LocalDate created,
                   Customer customer, Room room, int guests){
        this.bookingNumber = bookingNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.created = created;
        this.customer = customer;
        this.room = room;
        this.guests = guests;
        calculateTotalPrice();
    }

    public void setRoom(Room room){
        this.room = room;
        calculateTotalPrice();
    }

    public void setGuests(int guests) {
        this.guests = guests;
        calculateTotalPrice();
    }

    private void calculateTotalPrice(){
        if (this.room != null) {
            this.totalPrice = room.getBasePrice() * this.guests;
        }
    }
}
