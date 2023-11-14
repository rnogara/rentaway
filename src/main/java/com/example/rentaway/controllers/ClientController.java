package com.example.rentaway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rentaway.entities.ClientEntity;
import com.example.rentaway.services.ClientService;

@RestController
@RequestMapping
public class ClientController {
  
  @Autowired
  private ClientService clientService;
  
  @PostMapping("/signup")
  public ResponseEntity<String> createAcount(@RequestBody ClientEntity client) {
    clientService.createOrUpdateClient(client);
    return ResponseEntity.status(201).body("Account created");
  }

  @GetMapping("/admin/clients")
  public ResponseEntity<List<ClientEntity>> getClients() {
    List<ClientEntity> clients = clientService.getClients();
    return ResponseEntity.status(200).body(clients);
  }

  @PutMapping("/profile/{id}")
  public ResponseEntity<String> updateClient(@RequestBody ClientEntity client) {
    clientService.createOrUpdateClient(client);
    return ResponseEntity.status(200).body("Profile updated");
  }

  @DeleteMapping("/profile/{id}")
  public ResponseEntity<String> deleteClient(@RequestParam Integer id) {
    clientService.deleteClient(id);
    return ResponseEntity.status(200).body("Profile deleted");
  }
}
