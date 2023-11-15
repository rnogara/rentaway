package com.example.rentaway.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.rentaway.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer>{
  List<ClientEntity> findByEmail(String email);
}
