package com.example.hotellmanagersystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private int roomNumber;
    private double basePrice;
    private int beds;

    private LocalDate created;
    private LocalDate lastUpdated;
    //private User lastUpdatedBy;

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
}
