package com.example.hotelbookingapp.service;

import com.example.hotelbookingapp.entity.bookingManagement.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(Booking booking);

    Optional<Booking> getBookingById(Long id);

    List<Booking> getAllBookings();

    Booking updateBooking(Booking booking);

    void deleteBookingById(Long id);


}
