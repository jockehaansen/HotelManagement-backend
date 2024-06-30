package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.FindRoomsDTO;
import com.example.hotellmanagersystem.dto.basic.BasicBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedBookingDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Booking;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.BookingRepository;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.BookingService;
import com.example.hotellmanagersystem.services.CustomerService;
import com.example.hotellmanagersystem.services.RoomService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final CustomerService customerService;
    private final RoomService roomService;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;

    @Override
    public DetailedBookingDTO createBooking(DetailedBookingDTO booking) {
        Booking bookingToBeCreated = new Booking();
        bookingToBeCreated.setCreated(LocalDate.now());
        bookingToBeCreated.setCustomer(customerService.getCustomerByEmail(booking.getCustomerEmail()));
        bookingToBeCreated.setRooms(roomRepository.findAllById(booking.getRoomIDs()));
        return bookingToDetailedBookingDTO(bookingRepository.save(setBookingAttributes(booking, bookingToBeCreated)));
    }

    @Override
    public DetailedBookingDTO updateBooking(DetailedBookingDTO booking) {
        Booking bookingToBeUpdated = bookingRepository.findById(booking.getId())
                .orElseThrow(() -> new InvalidIDException("Error, address with id " + booking.getId() + " was not found"));
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
        DetailedBookingDTO detailedBookingDTO = modelMapper.map(booking, DetailedBookingDTO.class);
        detailedBookingDTO.setRoomIDs(booking.getRooms().stream().map(Room::getId).toList());
        return detailedBookingDTO;
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
        System.out.println(findRoomsDTO.getStartDate());
        System.out.println(findRoomsDTO.getEndDate());
        LocalDate startDate = LocalDate.parse(findRoomsDTO.getStartDate());
        LocalDate endDate = LocalDate.parse(findRoomsDTO.getEndDate());
        return roomRepository.findAll().stream()
                .filter(room -> room.getBeds() >= findRoomsDTO.getGuests())
                .filter(room -> isRoomAvailable(room, bookingRepository.findAll(), startDate, endDate))
                .map(roomService::roomToDetailedRoomDTO)
                .toList();
    }

    public boolean isRoomAvailable(Room room, List<Booking> bookings, LocalDate startDate, LocalDate endDate){
        for(Booking booking : bookings){
            if (booking.getRooms().contains(room) && !(endDate.isBefore(booking.getStartDate()) || startDate.isAfter(booking.getEndDate()))) {
                return false;
            }
        }
        return true;
    }


    //UTILITY
    private Booking setBookingAttributes(DetailedBookingDTO bookingDTO, Booking booking){
        BeanUtils.copyProperties(bookingDTO, booking, "id", "created");
        List<Room> rooms = new ArrayList<>();
        for (Long id : bookingDTO.getRoomIDs()) {
            rooms.add(roomService.getRoomById(id));
        }
        booking.setRooms(rooms);
        booking.setLastUpdated(LocalDate.now());
        return booking;
    }
}
