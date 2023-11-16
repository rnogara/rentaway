package com.example.rentaway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentaway.dto.LoginDto;
import com.example.rentaway.entities.ClientEntity;
import com.example.rentaway.services.ClientService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ClientController {
  
  @Autowired
  private ClientService clientService;
  
  @PostMapping("/signup")
  public ResponseEntity<ClientEntity> createAcount(@RequestBody ClientEntity client) {
    ClientEntity response = clientService.createOrUpdateClient(client);
    return ResponseEntity.status(201).body(response);
  }

  @GetMapping("/admin/clients")
  public ResponseEntity<List<ClientEntity>> getClients() {
    List<ClientEntity> clients = clientService.getClients();
    return ResponseEntity.status(200).body(clients);
  }

  @PostMapping("/login")
  public ResponseEntity<ClientEntity> login(@RequestBody LoginDto loginDto) {
    ClientEntity client = clientService.login(loginDto);
    return ResponseEntity.status(200).body(client);
  }

  @PutMapping("/profile/{id}")
  public ResponseEntity<String> updateClient(@RequestBody ClientEntity client) {
    clientService.createOrUpdateClient(client);
    return ResponseEntity.status(200).body("Profile updated");
  }

  @DeleteMapping("/profile/{id}")
  public ResponseEntity<String> deleteClient(@PathVariable String id) {
    Integer idClient = Integer.valueOf(id);
    clientService.deleteClient(idClient);
    return ResponseEntity.status(200).body("Profile deleted");
  }
}
