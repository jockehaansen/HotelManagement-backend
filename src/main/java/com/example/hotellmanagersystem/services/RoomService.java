package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.DTO.Basic.BasicRoomDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    Room updateRoom(Room room);
    void deleteRoomById(Long id);
    List<Room> getAllRooms();
    Room getRoomById(Long id);

    //DTO HANDLING
    List<BasicRoomDTO> getAllRoomsAsBasicDTO();
    List<DetailedRoomDTO> getAllRoomsAsDetailedDTO();
    BasicRoomDTO roomToBasicRoomDTO(Room room);
    DetailedRoomDTO roomToDetailedRoomDTO(Room room);
}
