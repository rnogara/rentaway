package com.example.rentaway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentaway.entities.BookingEntity;
import com.example.rentaway.repositories.BookingRepository;

@Service
public class BookingService {

  @Autowired
  private BookingRepository bookingRepository;

  public List<BookingEntity> getBookings(Integer idClient) {
    List<BookingEntity> bookings = new ArrayList<>();

    if (idClient != null) {
      bookings = bookingRepository.findByIdClient(idClient);
      System.out.println("Booking retrieved");
    } else {
      bookings = bookingRepository.findAll();
      System.out.println("Bookings retrieved");
    }
    
    return bookings;
  }

  public void createOrUpdateBooking(BookingEntity booking) {
    bookingRepository.save(booking);
    System.out.println("Booking created");
  }

  public void deleteBooking(Integer id) {
    bookingRepository.deleteById(id);
    System.out.println("Booking deleted");
  }
  
}
