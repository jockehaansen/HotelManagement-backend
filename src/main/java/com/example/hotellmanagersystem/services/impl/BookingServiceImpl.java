package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.CustomerBookingDTO;
import com.example.hotellmanagersystem.dto.FindRoomsDTO;
import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.repositories.CustomerRepository;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.BookingService;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.services.RoomService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.CustomerNotFoundException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final RoomService roomService;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    @Override
    public DetailedBookingDTO createBooking(CustomerBookingDTO booking) {
        //TODO this should return a ConfirmedBookingDTO
        if (!customerRepository.existsByEmail(booking.getCustomerEmail())){
            throw new CustomerNotFoundException("Customer not found");
        }
        return bookingToDetailedBookingDTO(bookingRepository.save(setCustomerBookingAttributes(booking, createAndSetNewBookingAttributes(booking))));
    }

    @Override
    public DetailedBookingDTO updateBooking(DetailedBookingDTO booking) {
        Booking bookingToBeUpdated = bookingRepository.findById(booking.getId())
                .orElseThrow(() -> new InvalidIDException("Error, booking with id " + booking.getId() + " was not found"));
        return bookingToDetailedBookingDTO(bookingRepository.save(setBookingAttributes(booking, bookingToBeUpdated)));
    }

    @Override
    public String deleteBookingById(Long id) {
        bookingRepository.delete(bookingRepository.findById(id).orElseThrow(() -> new InvalidIDException("Error, address with id " + id + " was not found")));
        return "Booking with id " + id + " was deleted successfully";
    }

    @Override
    public String deleteBookingByBookingNumber(Long bookingNumber){
        //TODO
        return null;
    }

    @Override
    public List<DetailedBookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream().map(this::bookingToDetailedBookingDTO).toList();
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

    @Override
    public List<DetailedRoomDTO> findAvailableRooms(FindRoomsDTO findRoomsDTO) {

        return roomRepository.findAll().stream()
                .filter(room -> room.getCapacity() >= findRoomsDTO.getGuests())
                .filter(room -> isRoomAvailable(room, bookingRepository.findAll(), findRoomsDTO.getStartDate(), findRoomsDTO.getEndDate()))
                .map(roomService::roomToDetailedRoomDTO)
                .toList();
    }

    public boolean isRoomAvailable(Room room, List<Booking> bookings, LocalDate startDate, LocalDate endDate) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room)) {
                if (!(endDate.isBefore(booking.getStartDate()) || startDate.isAfter(booking.getEndDate()))) {
                    return false;
                }
            }
        }
        return true;
    }

    //UTILITY
    private Booking setBookingAttributes(DetailedBookingDTO bookingDTO, Booking booking){
        BeanUtils.copyProperties(bookingDTO, booking, "id", "created", "bookingNumber");
        booking.setLastUpdated(LocalDate.now());
        return booking;
    }

    private Booking setCustomerBookingAttributes(CustomerBookingDTO bookingDTO, Booking booking){
        BeanUtils.copyProperties(bookingDTO, booking, "id", "created", "bookingNumber");
        booking.setLastUpdated(LocalDate.now());
        return booking;
    }

    private Booking createAndSetNewBookingAttributes(CustomerBookingDTO bookingDTO){
        Booking bookingToBeCreated = new Booking();
        bookingToBeCreated.setCustomer(customerService.getCustomerByEmail(bookingDTO.getCustomerEmail()));
        bookingToBeCreated.setRoom(roomRepository.findById(bookingDTO.getRoomId()).orElse(null));
        bookingToBeCreated.setBookingNumber(findAndSetNextBookingNumber(bookingRepository.findMaxBookingNumber()));
        return bookingToBeCreated;
    }

    private Long findAndSetNextBookingNumber(Long currentMaxBookingNumber){
        return currentMaxBookingNumber + 1;
    }
}
