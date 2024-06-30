package com.example.hotellmanagersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindRoomsDTO {

    private String startDate;
    private String endDate;
    private int guests;
}
