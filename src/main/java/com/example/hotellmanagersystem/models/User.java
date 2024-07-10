package com.example.hotellmanagersystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotEmpty(message = "Username is required")
    @Size(max = 255, message = "Username cannot be longer than 255 characters")
    private String userName;

    @NotEmpty(message = "Email is required")
    @Email
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 10, message = "Password has to be at least 10 characters")
    private String password;

    @Basic
    private LocalDate created;

    @Basic
    private LocalDate lastUpdated;

    @ManyToOne
    //TODO JOINCOLUMN?
    private User lastUpdatedBy;

    @PrePersist
    protected void onCreate(){
        this.created = LocalDate.now();
    }

    //private List<Role> roles;

    public User(String userName, String email, String password, LocalDate created) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.created = created;
    }
}
