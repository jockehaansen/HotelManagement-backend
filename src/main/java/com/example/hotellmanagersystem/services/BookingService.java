package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.dto.CustomerBookingDTO;
import com.example.hotellmanagersystem.dto.FindRoomsDTO;
import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Booking;

import java.util.List;

public interface BookingService {
    DetailedBookingDTO createBooking(CustomerBookingDTO booking);
    DetailedBookingDTO updateBooking(DetailedBookingDTO booking);
    String deleteBookingById(Long id);
    String deleteBookingByBookingNumber(Long bookingNumber);
    List<DetailedBookingDTO> getAllBookings();

    //DTO HANDLING
    BasicBookingDTO bookingToBasicBookingDTO(Booking booking);
    DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking);
    List<BasicBookingDTO> getAllBookingsAsBasicDTO();
    List<DetailedBookingDTO> getAllBookingsAsDetailedDTO();
    List<DetailedRoomDTO> findAvailableRooms(FindRoomsDTO findRoomsDTO);
}
