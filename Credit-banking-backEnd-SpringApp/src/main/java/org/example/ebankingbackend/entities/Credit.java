package org.example.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.ebankingbackend.enums.StatutCredit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_credit", discriminatorType = DiscriminatorType.STRING)
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateDemande;

    @Enumerated(EnumType.STRING)
    private StatutCredit statut;

    private LocalDate dateAcceptation;
    private BigDecimal montant;
    private int duree;
    private BigDecimal tauxInteret;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Remboursement> remboursements;
}
