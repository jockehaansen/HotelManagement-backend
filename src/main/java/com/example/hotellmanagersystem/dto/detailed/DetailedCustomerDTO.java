package com.example.hotellmanagersystem.dto.detailed;

import com.example.hotellmanagersystem.dto.basic.BasicAddressDTO;
import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.models.User;
import jakarta.persistence.Basic;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedCustomerDTO {
    private UUID id;

    @NotEmpty(message = "Firstname is required")
    @Size(max = 255, message = "Firstname has to be less than 255 characters")
    private String firstName;

    @NotEmpty(message = "Lastname is required")
    @Size(max = 255, message = "Lastname has to be less than 255 characters")
    private String lastName;

    @NotEmpty(message = "Phone-number is required")
    @Size(min=10, max = 17, message = "Phone number has to be between 10 and 17 numbers")
    private String phoneNumber;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    @NotNull(message = "Address is required")
    private BasicAddressDTO address;

    private List<BasicBookingDTO> bookings;

    @Basic
    private LocalDate created;

    @Basic
    private LocalDate lastUpdated;

    private User lastUpdatedBy;
}
