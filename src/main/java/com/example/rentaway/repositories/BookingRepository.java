package com.example.rentaway.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentaway.entities.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{
  List<BookingEntity> findByClientId(int clientId);
}