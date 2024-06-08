package com.example.hotellmanagersystem.DTO.Basic;

import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.models.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicBookingDTO {
    private Long bookingNumber;
    private LocalDate startDate;
    private Local endDate;
    private double totalPrice;
    private Customer customer;
    private List<Room> rooms;
}
