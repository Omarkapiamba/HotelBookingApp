package com.example.hotelbookingapp.repository;

import com.example.hotelbookingapp.entity.bookingManagement.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
