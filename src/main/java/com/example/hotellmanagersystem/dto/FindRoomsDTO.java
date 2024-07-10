package com.example.hotellmanagersystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindRoomsDTO {

    @NotNull
    private String startDate;
    private String endDate;
    @NotNull
    private int guests;
    private String customerEmail;
}
