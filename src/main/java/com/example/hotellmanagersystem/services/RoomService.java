package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.models.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(Room room);
    Room updateRoom(Room room);
    void deleteRoomById(Long id);
    List<Room> getAllRooms();
}
