package com.example.hotellmanagersystem.repositories;

import com.example.hotellmanagersystem.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
