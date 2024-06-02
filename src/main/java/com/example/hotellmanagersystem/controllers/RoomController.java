package com.example.hotellmanagersystem.controllers;

import com.example.hotellmanagersystem.models.Room;
import com.example.hotellmanagersystem.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    void createRoom(){

    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable Long id){

    }

    @PutMapping("/update/{id}")
    void updateById(@PathVariable Long id){

    }

    @GetMapping("")
    List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

}
