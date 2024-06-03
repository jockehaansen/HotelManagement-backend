package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.DTO.Basic.BasicRoomDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.RoomService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidRoomAttributesException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room createRoom(Room room) {
        if (isRoomAttributesOK(room)){
            return roomRepository.save(room);
        }
        else {
            throw  new InvalidRoomAttributesException("Error, beds attributes is not valid, needs to be between 1 - 4");
        }
    }

    @Override
    public Room updateRoom(Room room) {
        Room roomToBeUpdated = roomRepository.findById(room.getId())
                .orElseThrow(() -> new InvalidIDException("Error, room id " + room.getId() + " was not found"));
        if (isRoomAttributesOK(room)) {
            roomToBeUpdated.setRoomNumber(room.getRoomNumber());
            roomToBeUpdated.setBeds(room.getBeds());
            roomToBeUpdated.setLastUpdated(LocalDate.now());
            return roomRepository.save(roomToBeUpdated);
        } else {
            throw new InvalidRoomAttributesException("Error, beds attributes is not valid, needs to be between 1 - 4");
        }
    }

    @Override
    public String deleteRoomById(Long id) {
            Room room = roomRepository.findById(id).orElseThrow(() -> new InvalidIDException("Error, room id " + id + " was not found"));
            roomRepository.delete(room);
            return "Room with id " + id + " has been deleted successfully";
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new InvalidIDException("Error, room id " + id + " was not found"));
    }

    //DTO HANDLING
    @Override
    public List<BasicRoomDTO> getAllRoomsAsBasicDTO() {
        return roomRepository.findAll().stream().map(this::roomToBasicRoomDTO).collect(Collectors.toList());
    }

    @Override
    public BasicRoomDTO roomToBasicRoomDTO(Room room){
        return BasicRoomDTO.builder().roomNumber(room.getRoomNumber()).basePrice(room.getBasePrice()).beds(room.getBeds()).build();
    }

    @Override
    public DetailedRoomDTO roomToDetailedRoomDTO(Room room){
        return DetailedRoomDTO.builder().id(room.getId()).roomNumber(room.getRoomNumber()).basePrice(room.getBasePrice())
                .beds(room.getBeds()).created(room.getCreated()).lastUpdated(room.getLastUpdated()).build();
    }

    @Override
    public List<DetailedRoomDTO> getAllRoomsAsDetailedDTO() {
        return roomRepository.findAll().stream().map(this::roomToDetailedRoomDTO).collect(Collectors.toList());
    }

    //UTILITY
    private boolean isRoomAttributesOK(Room room){
        return room.getBeds() <= 4 && room.getBeds() > 0;
    }

}
