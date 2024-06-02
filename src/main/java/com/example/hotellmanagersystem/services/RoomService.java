package com.example.hotellmanagersystem.services;

import com.example.hotellmanagersystem.models.Room;

import java.util.List;

public interface RoomService {
    void createRoom();
    void updateRoom();
    void deleteRoomById(Long id);
    List<Room> getAllRooms();
}
