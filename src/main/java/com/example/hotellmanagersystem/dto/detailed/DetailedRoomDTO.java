package com.example.hotellmanagersystem.dto.detailed;

import com.example.hotellmanagersystem.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedRoomDTO {

    @NotBlank(message = "RoomID is required")
    private Long id;

    @NotBlank(message = "RoomNumber is required")
    private int roomNumber;

    @NotBlank(message = "BasePrice is required")
    private double basePrice;

    @NotBlank(message = "Capacity is required")
    private int capacity;

    private LocalDate created;
    private LocalDate lastUpdated;
    private User lastUpdatedBy;
}
