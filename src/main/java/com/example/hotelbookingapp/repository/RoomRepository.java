package com.example.hotelbookingapp.repository;

import com.example.hotelbookingapp.entity.hotelManagement.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
