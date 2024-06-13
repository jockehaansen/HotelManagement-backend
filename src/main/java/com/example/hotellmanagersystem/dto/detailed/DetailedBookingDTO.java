package com.example.hotellmanagersystem.dto.detailed;

import com.example.hotellmanagersystem.dto.basic.BasicCustomerDTO;
import com.example.hotellmanagersystem.dto.basic.BasicRoomDTO;
import com.example.hotellmanagersystem.models.Customer;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.models.User;
import jakarta.persistence.Basic;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class DetailedBookingDTO {
    private Long id;

    //denna ska auto-genereras i framtiden
    @NotNull(message = "Booking number is required")
    private Long bookingNumber;

    @NotNull(message = "StartDate is required")
    @Basic
    private LocalDate startDate;

    @NotNull(message = "EndDate is required")
    @Basic
    private LocalDate endDate;

    @NotNull(message = "TotalPrice is required")
    private double totalPrice;

    @NotNull(message = "Created is required")
    @Basic
    private LocalDate created;

    @Basic
    private LocalDate lastUpdated;

    //TODO JOINCOLUMN?
    private User lastUpdatedBy;

    private BasicCustomerDTO customer;

    private List<DetailedRoomDTO> rooms;

    //specific for creating bookings
    @NotBlank(message = "Customer email is required")
    private String customerEmail;

    @NotNull(message = "Room ID's is required")
    private List<Long> roomIDs;
}
