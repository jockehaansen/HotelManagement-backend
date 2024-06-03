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

    //DTO HANDLING
    List<BasicRoomDTO> getAllRoomsAsBasicDTO();
    List<DetailedRoomDTO> getAllRoomsAsDetailedDTO();
}
