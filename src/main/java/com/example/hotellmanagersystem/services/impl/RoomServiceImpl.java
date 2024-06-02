package com.example.hotellmanagersystem.services.impl;

import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.repositories.RoomRepository;
import com.example.hotellmanagersystem.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public void createRoom() {
    }

    @Override
    public void updateRoom() {
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
