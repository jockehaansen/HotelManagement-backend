package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.DTO.Basic.BasicBookingDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return BasicBookingDTO.builder().startDate(booking.getStartDate()).endDate(booking.getEndDate())
                .bookingNumber(booking.getBookingNumber()).customer(booking.getCustomer()).rooms(booking.getRooms()).totalPrice(booking.getTotalPrice()).build();
    }

    @Override
    public DetailedBookingDTO bookingToDetailedBookingDTO(Booking booking) {
        return DetailedBookingDTO.builder().bookingNumber(booking.getBookingNumber()).created(booking.getCreated())
                .id(booking.getId()).endDate(booking.getEndDate()).startDate(booking.getStartDate()).lastUpdated(booking.getLastUpdated())
                .customer(booking.getCustomer()).updatedBy(booking.getUpdatedBy()).rooms(booking.getRooms()).totalPrice(booking.getTotalPrice()).build();
    }

    @Override
    public List<BasicBookingDTO> getAllBookingsAsBasicDTO() {
        return bookingRepository.findAll().stream().map(this::bookingToBasicBookingDTO).collect(Collectors.toList());
    }

    @Override
    public List<DetailedBookingDTO> getAllBookingsAsDetailedDTO() {
        return bookingRepository.findAll().stream().map(this::bookingToDetailedBookingDTO).collect(Collectors.toList());
    }
}
