package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.DTO.Basic.BasicBookingDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking updateBooking(Booking booking);
    String deleteBookingById(Long id);
    String deleteBookingByBookingNumber(Long bookingNumber);
    List<Booking> getAllBookings();

    //DTO HANDLING
    BasicBookingDTO bookingToBasicBookingDTO(Booking booking);
    DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking);
    List<BasicBookingDTO> getAllBookingsAsBasicDTO();
    List<DetailedBookingDTO> getAllBookingsAsDetailedDTO();
}
