package com.example.hotellmanagersystem.dto.detailed;

import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.basic.BasicRoomDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingConfirmationDTO {

    private Long bookingNumber;
    private BasicCustomerDTO customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private BasicRoomDTO room;

}
