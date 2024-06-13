package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.dto.basic.BasicRoomDTO;
import com.example.hotellmanagersystem.dto.detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.services.RoomService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @Transactional
    @PostMapping("/create")
    public Room createRoom(@Valid @RequestBody Room room){
        return roomService.createRoom(room);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id){
        return roomService.deleteRoomById(id);
    }

    @Transactional
    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room){
        return roomService.updateRoom(room);
    }

    @GetMapping("/room/{id}")
    BasicRoomDTO getRoom(@PathVariable Long id){
        return roomService.roomToBasicRoomDTO(roomService.getRoomById(id));
    }

    @GetMapping("/room/{id}/detailed")
    DetailedRoomDTO getDetailedRoom(@PathVariable Long id){
        return roomService.roomToDetailedRoomDTO(roomService.getRoomById(id));
    }

    @GetMapping("/basic")
    public List<BasicRoomDTO> getAllBasicRoomDTOs(){
        return roomService.getAllRoomsAsBasicDTO();
    }

    @GetMapping("/detailed")
    public List<DetailedRoomDTO> getAllDetailedRoomDTOs(){
        return roomService.getAllRoomsAsDetailedDTO();
    }

}
