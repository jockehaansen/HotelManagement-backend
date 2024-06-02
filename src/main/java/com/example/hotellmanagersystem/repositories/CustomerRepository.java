package com.example.hotellmanagersystem.repositories;

import com.example.hotellmanagersystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
