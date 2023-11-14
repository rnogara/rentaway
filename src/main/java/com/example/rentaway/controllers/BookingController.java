package com.example.rentaway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentaway.entities.BookingEntity;
import com.example.rentaway.services.BookingService;

@RestController
@RequestMapping
public class BookingController {
  
  @Autowired
  BookingService bookingService;

  @PostMapping("/rent")
  public ResponseEntity<String> createBooking(@RequestBody BookingEntity booking) {
    bookingService.createOrUpdateBooking(booking);
    return ResponseEntity.status(201).body("Booking created");
  }

  @GetMapping("/admin/bookings")
  public ResponseEntity<List<BookingEntity>> getBookings() {
    List<BookingEntity> bookings = bookingService.getBookings(null);
    return ResponseEntity.status(200).body(bookings);
  }

  @GetMapping("/profile/{id}")
  public ResponseEntity<List<BookingEntity>> getBooking(@RequestParam Integer clientId) {
    List<BookingEntity> booking = bookingService.getBookings(clientId);
    return ResponseEntity.status(200).body(booking);
  }

  @PutMapping("/admin/bookings")
  public ResponseEntity<String> updateBooking(@RequestBody BookingEntity booking) {
    bookingService.createOrUpdateBooking(booking);
    return ResponseEntity.status(200).body("Booking updated");
  }

  @DeleteMapping("/profile/{id}")
  public ResponseEntity<String> deleteBooking(@RequestBody Integer id) {
    bookingService.deleteBooking(id);
    return ResponseEntity.status(200).body("Booking deleted");
  }
}