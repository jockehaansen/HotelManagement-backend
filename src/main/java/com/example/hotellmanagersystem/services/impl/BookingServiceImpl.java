package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public void createBooking() {

    }

    @Override
    public void updateBooking() {

    }

    @Override
    public void deleteBooking() {

    }

    @Override
    public void getAllBookings() {

    }
}
