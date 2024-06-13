package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.services.BookingService;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final RoomService roomService;
    private final ModelMapper modelMapper;
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
        return bookingRepository.findAll();
    }

    //DTO HANDLING
    @Override
    public BasicBookingDTO bookingToBasicBookingDTO(Booking booking) {
        return modelMapper.map(booking, BasicBookingDTO.class);
    }

    @Override
    public DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking) {
        return modelMapper.map(booking, DetailedBookingDTO.class);
    }

    @Override
    public List<BasicBookingDTO> getAllBookingsAsBasicDTO() {
        return bookingRepository.findAll().stream().map(this::bookingToBasicBookingDTO).toList();
    }

    @Override
    public List<DetailedBookingDTO> getAllBookingsAsDetailedDTO() {
        return bookingRepository.findAll().stream().map(this::bookingToDetailedBookingDTO).toList();
    }
}
