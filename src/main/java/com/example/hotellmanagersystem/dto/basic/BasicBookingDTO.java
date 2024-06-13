package com.example.hotellmanagersystem.dto.basic;

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
public class BasicBookingDTO {
    private Long bookingNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private BasicCustomerDTO customer;
    private List<BasicRoomDTO> rooms;
}
