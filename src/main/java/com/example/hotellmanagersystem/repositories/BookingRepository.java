package com.example.hotellmanagersystem.repositories;

import com.example.hotellmanagersystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
