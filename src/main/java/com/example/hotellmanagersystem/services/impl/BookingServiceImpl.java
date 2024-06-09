package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.DTO.Basic.BasicBookingDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return  null;
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return null;
    }

    @Override
    public String deleteBookingById(Long id) {
        return null;
    }

    @Override
    public String deleteBookingByBookingNumber(Long bookingNumber){
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        return null;
    }

    //DTO HANDLING
    @Override
    public BasicBookingDTO bookingToBasicBookingDTO(Booking booking) {
        return null;
    }

    @Override
    public DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking) {
        return null;
    }

    @Override
    public List<BasicBookingDTO> getAllBookingsAsBasicDTO() {
        return null;
    }

    @Override
    public List<DetailedBookingDTO> getAllBookingsAsDetailedDTO() {
        return null;
    }
}
