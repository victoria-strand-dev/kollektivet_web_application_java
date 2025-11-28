package com.example.myNewBackend.controllers;

import com.example.myNewBackend.models.User;
import com.example.myNewBackend.repositories.RoomRepository;
import com.example.myNewBackend.models.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms") // alle endepunkt starter med /api/users
@CrossOrigin(origins = "*") // lar deg hente data fra frontend uten CORS-feil
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll(); // sender JSON
    }

    @PostMapping
    public Room addUser(@RequestBody Room room) {
        return roomRepository.save(room);
    }

}
