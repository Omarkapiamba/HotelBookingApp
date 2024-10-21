package com.example.hotelbookingapp.service.impl;

import com.example.hotelbookingapp.entity.bookingManagement.Booking;
import com.example.hotelbookingapp.exceptions.BookingException;
import com.example.hotelbookingapp.repository.BookingRepository;
import com.example.hotelbookingapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl (BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {

        if (bookingRepository.findById(id).isPresent()) {
            return bookingRepository.findById(id);
        } else
            throw new BookingException(String.format("Bokning med id: %s finns inte", id));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Booking booking) {
        Long bookingId = booking.getId();

        if (bookingRepository.findById(bookingId).isPresent()){
          return bookingRepository.save(booking);
        } else
            throw new BookingException(String.format("Bookning med id: %s finns inte", bookingId));
    }

    @Override
    public void deleteBookingById(Long id) {

        if (bookingRepository.existsById(id)){
            bookingRepository.deleteById(id);
        } else
            throw new BookingException(String.format("Bookning med id: %s finns inte", id));
    }
}

