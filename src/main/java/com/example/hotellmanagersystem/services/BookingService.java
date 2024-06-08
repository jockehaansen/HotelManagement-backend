package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.DTO.Basic.BasicBookingDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;

import java.util.List;

public interface BookingService {
    void createBooking();
    void updateBooking();
    void deleteBooking();
    void getAllBookings();

    //DTO HANDLING
    BasicBookingDTO bookingToBasicBookingDTO(Booking booking);
    DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking);
    List<BasicBookingDTO> getAllBookingsAsBasicDTO();
    List<DetailedBookingDTO> getAllBookingsAsDetailedDTO();
}
