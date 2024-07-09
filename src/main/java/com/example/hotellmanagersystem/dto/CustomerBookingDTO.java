package com.example.hotellmanagersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBookingDTO {

    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private int guests;
    private Long roomId;
}
