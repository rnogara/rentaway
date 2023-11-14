package com.example.rentaway.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rentaway.entities.CarEntity;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
  List<CarEntity> findByAvailability(boolean availability);
}
