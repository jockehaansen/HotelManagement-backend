package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.DTO.Basic.BasicRoomDTO;
import com.example.hotellmanagersystem.DTO.Detailed.DetailedRoomDTO;
import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.services.RoomService;
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

    @PostMapping("/create")
    Room createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    void deleteRoom(@PathVariable Long id){

    }

    @PutMapping("/update")
    Room updateRoom(@RequestBody Room room){
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
