package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.services.BookingService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Transactional
    @PostMapping("/create")
    public DetailedBookingDTO createBooking(@Valid @RequestBody DetailedBookingDTO booking){
        return bookingService.createBooking(booking);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteBookingById(@PathVariable Long id){
        return bookingService.deleteBookingById(id);
    }

    @Transactional
    @PutMapping("/update")
    public DetailedBookingDTO updateBooking(@Valid @RequestBody DetailedBookingDTO booking){
        return bookingService.updateBooking(booking);
    }

    @GetMapping("")
    List<Booking> getAllBookings(){
        //TODO ska lämna ifrån sig detailedDTOS
        return bookingService.getAllBookings();
    }

    @GetMapping("/basic")
    List<BasicBookingDTO> getAllBookingsAsBasicDTOs(){
        return bookingService.getAllBookingsAsBasicDTO();
    }

    @GetMapping("/{id}")
    DetailedBookingDTO getBookingById(@PathVariable Long id){
        //TODO ska lämna ifrån sig en detailed booking
        return null;
    }

}
