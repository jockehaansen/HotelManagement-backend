package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void createRoom() {

    }

    @Override
    public void updateRoom() {

    }

    @Override
    public void deleteRoom() {

    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
