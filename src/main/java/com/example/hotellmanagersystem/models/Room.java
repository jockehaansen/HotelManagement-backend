package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Room number is required")
    private int roomNumber;

    @NotNull(message = "Base price is required")
    private double basePrice;

    @NotNull(message = "Beds is required")
    @Min(1)
    @Max(4)
    private int beds;

    @NotNull(message = "Created is required")
    @Basic
    private LocalDate created;

    @Basic
    private LocalDate lastUpdated;

    @ManyToOne
    //TODO JOINCOLUMN?
    private User lastUpdatedBy;

    private void setBasePrice() {
        switch (beds) {
            case 1:
                this.basePrice = 1000;
                break;
            case 2:
                this.basePrice = 2000;
                break;
            case 3:
                this.basePrice = 3000;
                break;
            case 4:
                this.basePrice = 4000;
                break;
            default:
                this.basePrice = 0; // Handle unexpected values
                break;
        }
    }
    public void setBeds(int beds) {
        this.beds = beds;
        setBasePrice(); // Automatically set the price when beds are set
    }
    @PrePersist
    protected void onCreate() {
        this.created = LocalDate.now();
    }

    public Room(int roomNumber, double basePrice, int beds, LocalDate created) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.beds = beds;
        this.created = created;
    }
}
