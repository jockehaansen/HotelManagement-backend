package com.example.hotellmanagersystem.DTO.Basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicRoomDTO {

    private int roomNumber;
    private double basePrice;
    private int beds;
}
