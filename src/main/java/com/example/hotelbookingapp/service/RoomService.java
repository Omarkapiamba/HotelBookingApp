package com.example.hotelbookingapp.service;

import com.example.hotelbookingapp.entity.hotelManagement.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    Room createRoom(Room room);

    Optional<Room> getRoomById(Long id);

    List<Room> getAllRooms();

    Room updateRoom(Room room);

    void deleteRoomById(Long id);

}
