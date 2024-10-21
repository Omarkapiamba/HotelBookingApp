package com.example.hotelbookingapp.service;

import com.example.hotelbookingapp.entity.hotelManagement.Hotel;
import com.example.hotelbookingapp.entity.hotelManagement.Room;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    Optional<Hotel> getHotelById(Long id);

    List<Hotel> getAllHotels();

    List<Room> getAllRoomsByHotelId(Long id);

    Hotel updateHotel(Hotel hotel);

    void deleteHotelById(Long id);


}
