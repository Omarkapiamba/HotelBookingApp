package com.example.hotelbookingapp.repository;

import com.example.hotelbookingapp.entity.hotelManagement.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRespository extends JpaRepository<Hotel, Long> {

}
