package org.example.ebankingbackend.dtos;

import lombok.Data;
import org.example.ebankingbackend.enums.StatutCredit;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private StatutCredit statut;
    private LocalDate dateAcceptation;
    private BigDecimal montant;
    private int duree;
    private BigDecimal tauxInteret;
    private Long clientId;
}
