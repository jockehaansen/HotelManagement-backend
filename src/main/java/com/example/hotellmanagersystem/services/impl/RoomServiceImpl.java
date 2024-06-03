package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.RoomService;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidRoomAttributesException;
import com.example.hotellmanagersystem.utilities.exceptionHandlers.InvalidRoomIDException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
                .orElseThrow(() -> new InvalidRoomIDException("Error, room id " + room.getId() + " was not found"));
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
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    //check for room attributes to be correct before saving it
    private boolean isRoomAttributesOK(Room room){
        return room.getBeds() <= 4 && room.getBeds() > 0;
    }
}
