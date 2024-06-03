package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

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

    @GetMapping("")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

}
