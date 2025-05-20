package org.example.ebankingbackend.repositories;


import org.example.ebankingbackend.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByClientId(Long clientId);
}
