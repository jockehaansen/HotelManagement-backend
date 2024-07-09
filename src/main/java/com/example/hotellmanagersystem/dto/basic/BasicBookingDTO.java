package com.example.hotellmanagersystem.dto.basic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
    private String customerEmail;
    private Long roomId;
}
