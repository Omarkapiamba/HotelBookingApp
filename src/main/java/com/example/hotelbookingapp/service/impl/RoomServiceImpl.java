package com.example.hotelbookingapp.service.impl;

import com.example.hotelbookingapp.entity.hotelManagement.Room;
import com.example.hotelbookingapp.exceptions.RoomException;
import com.example.hotelbookingapp.repository.RoomRepository;
import com.example.hotelbookingapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(Room room) {

        int roomNumber = room.getRoomNumber();

        if (roomRepository.findAll().stream()
                .anyMatch(room1 -> room1.getRoomNumber() == roomNumber)) {
            throw new RoomException(String.format("Room med rumsnummer: %s finns redan", roomNumber));
        } else

            return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getRoomById(Long id) {

        return roomRepository.findById(id)
                .map(Optional::of)
                .orElseThrow(() -> new RoomException("Rum med id: %s finns inte"));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();

    }

    @Override
    public Room updateRoom(Room room) {

        Long roomId = room.getId();

        if (roomRepository.existsById(roomId)) {
            return roomRepository.save(room);
        } else
            throw new RoomException(String.format("Rum med id: %s hittades inte", roomId));
    }

    @Override
    public void deleteRoomById(Long id) {

        if (roomRepository.findById(id).isPresent()) {

            roomRepository.deleteById(id);

        } else

            throw new RoomException(String.format("Rummet med id %s finns inte", id));
    }

}
