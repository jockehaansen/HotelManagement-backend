package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.dto.basic.BasicRoomDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.RoomService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidIDException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidRoomAttributesException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

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
        //TODO copyproperties bean??
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
        return roomRepository.findAll().stream().map(this::roomToBasicRoomDTO).toList();
    }

    @Override
    public List<DetailedRoomDTO> getAllRoomsAsDetailedDTO() {
        return roomRepository.findAll().stream().map(this::roomToDetailedRoomDTO).toList();
    }

    @Override
    public BasicRoomDTO roomToBasicRoomDTO(Room room){
        return modelMapper.map(room, BasicRoomDTO.class);
    }

    @Override
    public DetailedRoomDTO roomToDetailedRoomDTO(Room room){
        return modelMapper.map(room, DetailedRoomDTO.class);
    }

    //UTILITY
    private boolean isRoomAttributesOK(Room room){
        return room.getBeds() <= 4 && room.getBeds() > 0;
    }

}
