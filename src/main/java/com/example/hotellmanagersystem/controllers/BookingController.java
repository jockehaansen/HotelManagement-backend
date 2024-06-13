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
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    @Transactional
    @PostMapping("/create")
    public DetailedBookingDTO createBokning(@Valid @RequestBody DetailedBookingDTO booking){
        return bookingService.createBooking(booking);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return bookingService.deleteBookingById(id);
    }

    @Transactional
    @PutMapping("/update")
    public DetailedBookingDTO updateBooking(@Valid @RequestBody DetailedBookingDTO booking){
        return bookingService.updateBooking(booking);
    }

    @GetMapping("")
    List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/basic")
    List<BasicBookingDTO> getAllBookingsAsBasicDTOs(){
        return bookingService.getAllBookingsAsBasicDTO();
    }

    @GetMapping("/detailed")
    List<DetailedBookingDTO> getAllBookingsAsDetailedDTOs(){
        return bookingService.getAllBookingsAsDetailedDTO();
    }
}
