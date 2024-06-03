package com.example.hotellmanagersystem.DTO.Detailed;

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
    private Long id;
    private int roomNumber;
    private double basePrice;
    private int beds;

    private LocalDate created;
    private LocalDate lastUpdated;
    //private User lastUpdatedBy;
}
