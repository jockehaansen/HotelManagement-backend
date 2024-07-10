package com.example.hotellmanagersystem.dto;

import jakarta.persistence.Basic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBookingDTO {

    @NotBlank(message = "CustomerEmail is required")
    private String customerEmail;

    @NotNull(message = "StartDate is required")
    @Basic
    private LocalDate startDate;

    @NotNull(message = "EndDate is required")
    @Basic
    private LocalDate endDate;

    @NotNull(message = "Number of guests is required")
    private int guests;

    @NotNull(message = "RoomID is required")
    private Long roomId;
}
