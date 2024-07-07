package com.example.hotellmanagersystem.repositories;

import com.example.hotellmanagersystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {


    @Query("SELECT COALESCE(MAX(b.bookingNumber), 999) FROM Booking b")
    Long findMaxBookingNumber();
}
