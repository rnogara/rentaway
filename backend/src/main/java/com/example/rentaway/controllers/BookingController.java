package com.example.rentaway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentaway.entities.BookingEntity;
import com.example.rentaway.services.BookingService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class BookingController {
  
  @Autowired
  BookingService bookingService;

  @PostMapping("/rent/{id}")
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
  public ResponseEntity<List<BookingEntity>> getBooking(@PathVariable String id) {
    Integer idClient = Integer.valueOf(id);
    List<BookingEntity> booking = bookingService.getBookings(idClient);
    return ResponseEntity.status(200).body(booking);
  }

  @PutMapping("/admin/bookings")
  public ResponseEntity<String> updateBooking(@RequestBody BookingEntity booking) {
    bookingService.createOrUpdateBooking(booking);
    return ResponseEntity.status(200).body("Booking updated");
  }

  @DeleteMapping("/profile/{id}/bookings/{idBooking}")
  public ResponseEntity<String> deleteBooking(@PathVariable String idBooking) {
    bookingService.deleteBooking(Integer.valueOf(idBooking));
    return ResponseEntity.status(200).body("Booking deleted");
  }
}