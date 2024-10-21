package com.example.hotelbookingapp.controller;

import com.example.hotelbookingapp.entity.hotelManagement.Room;
import com.example.hotelbookingapp.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/room")
public class RoomController {
    private final RoomServiceImpl roomService;

    @Autowired
    public RoomController(RoomServiceImpl roomService) {
        this.roomService = roomService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Room>> getRoomById(@PathVariable Long id) {
        Optional<Room> existingRoom = roomService.getRoomById(id);
        if (existingRoom.isPresent()) {
            return new ResponseEntity<>(existingRoom, HttpStatus.OK);
        } else
            return new ResponseEntity<>(existingRoom, HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> roomList = roomService.getAllRooms();
        return new ResponseEntity<>(roomList, HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteRoomById(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return new ResponseEntity<>(String.format("Rummet med id: %s är nu raderad.", id), HttpStatus.ACCEPTED);
    }
}
