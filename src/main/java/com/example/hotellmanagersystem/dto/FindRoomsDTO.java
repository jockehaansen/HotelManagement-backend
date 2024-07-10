package com.example.hotellmanagersystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindRoomsDTO {

    private LocalDate startDate;
    private LocalDate endDate;
    private int guests;
    private String customerEmail;
}
