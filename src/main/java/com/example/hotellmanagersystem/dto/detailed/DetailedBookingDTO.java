package com.example.hotellmanagersystem.dto.detailed;


import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.basic.BasicRoomDTO;
import com.example.hotellmanagersystem.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@JsonIgnoreProperties({"customer.bookings"})
public class DetailedBookingDTO {
    private Long id;

    //denna ska auto-genereras i framtiden
    //@NotNull(message = "Booking number is required")
    private Long bookingNumber;

    @NotNull(message = "StartDate is required")
    @Basic
    private LocalDate startDate;

    @NotNull(message = "EndDate is required")
    @Basic
    private LocalDate endDate;

    //@NotNull(message = "TotalPrice is required")
    private double totalPrice;

    private BasicRoomDTO room;
    private BasicCustomerDTO customer;

    @Basic
    private LocalDate created;

    @Basic
    private LocalDate lastUpdated;

    private User lastUpdatedBy;




}