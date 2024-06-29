package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;

import java.util.List;

public interface BookingService {
    DetailedBookingDTO createBooking(DetailedBookingDTO booking);
    DetailedBookingDTO updateBooking(DetailedBookingDTO booking);
    String deleteBookingById(Long id);
    String deleteBookingByBookingNumber(Long bookingNumber);
    List<DetailedBookingDTO> getAllBookings();

    //DTO HANDLING
    BasicBookingDTO bookingToBasicBookingDTO(Booking booking);
    DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking);
    List<BasicBookingDTO> getAllBookingsAsBasicDTO();
    List<DetailedBookingDTO> getAllBookingsAsDetailedDTO();
}
