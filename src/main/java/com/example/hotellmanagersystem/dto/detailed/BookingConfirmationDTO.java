package com.example.hotellmanagersystem.dto.detailed;

import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.basic.BasicRoomDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingConfirmationDTO {

    @NotBlank(message = "Customer is required")
    private BasicCustomerDTO customer;

    @NotBlank(message = "Booking is required")
    private BasicBookingDTO booking;
}
