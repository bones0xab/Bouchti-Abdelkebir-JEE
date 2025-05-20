package org.example.ebankingbackend.repositories;


import org.example.ebankingbackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Optional: add method to find by email
    Client findByEmail(String email);
}
