package com.example.hotellmanagersystem.dto.basic;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicCustomerDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Long addressId;
    private List<Long> bookingIds;
}
