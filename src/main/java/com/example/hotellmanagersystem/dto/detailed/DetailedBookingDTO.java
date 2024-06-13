package com.example.hotellmanagersystem.dto.detailed;

import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedBookingDTO {
    private Long id;
    private Long bookingNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private LocalDate created;
    private LocalDate lastUpdated;
    private User updatedBy;
    private Customer customer;
    private List<Room> rooms;
}
