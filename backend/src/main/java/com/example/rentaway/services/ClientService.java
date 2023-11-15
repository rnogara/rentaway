package com.example.rentaway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rentaway.entities.ClientEntity;
import com.example.rentaway.repositories.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public List<ClientEntity> getClients() {
    List<ClientEntity> clients = clientRepository.findAll();
    System.out.println("Clients retrieved");
    return clients;
  }

  public void login(String email, String password) {
    List<ClientEntity> clients = clientRepository.findByEmail(email);
    if (!clients.isEmpty() && clients.get(0).getPassword().equals(password)) {
      System.out.println("Login successful");
    } else {
      System.out.println("Login failed");
    }
  }
  
  public void createOrUpdateClient(ClientEntity client) {
    clientRepository.save(client);
    System.out.println("Client created");
  }

  public void deleteClient(Integer id) {
    clientRepository.deleteById(id);
    System.out.println("Client deleted");
  }
}
