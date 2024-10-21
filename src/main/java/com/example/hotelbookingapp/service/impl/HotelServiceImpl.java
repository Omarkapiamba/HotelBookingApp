package com.example.hotelbookingapp.service.impl;

import com.example.hotelbookingapp.entity.hotelManagement.Hotel;
import com.example.hotelbookingapp.entity.hotelManagement.Room;
import com.example.hotelbookingapp.exceptions.HotelException;
import com.example.hotelbookingapp.repository.HotelRespository;
import com.example.hotelbookingapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRespository hotelRespository;

    @Autowired
    public HotelServiceImpl(HotelRespository hotelRespository) {
        this.hotelRespository = hotelRespository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelAdress = hotel.getAddress();

        if (hotelRespository.findAll().stream()
                .anyMatch(hotel1 -> hotel1.getAddress().equals(hotelAdress))) {
            throw new HotelException(String.format("Finns redan ett hotel på adressen: %s", hotelAdress));
        } else

            return hotelRespository.save(hotel);
    }

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        Optional<Hotel> existingHotel = hotelRespository.findById(id);

        if (existingHotel.isPresent()) {
            return existingHotel;
        } else
            throw new HotelException(String.format("Hotellet med id: %s finns inte", id));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRespository.findAll();

    }

    @Override
    public List<Room> getAllRoomsByHotelId(Long id) {
        return null;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Long hotelId = hotel.getId();

        if (hotelRespository.existsById(hotelId)) {
            return hotelRespository.save(hotel);
        } else
            throw new HotelException(String.format("Hotel med id: %s hittades inte", hotelId));
    }

    @Override
    public void deleteHotelById(Long id) {

        if (hotelRespository.existsById(id)) {
            hotelRespository.deleteById(id);
        } else
            throw new HotelException(String.format("Hotel med id: %s hittades inte", id));


    }
}
