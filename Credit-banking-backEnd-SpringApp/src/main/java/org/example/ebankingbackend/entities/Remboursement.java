package org.example.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.ebankingbackend.enums.TypeRemboursement;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data

@Entity
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private BigDecimal montant;

    @Enumerated(EnumType.STRING)
    public TypeRemboursement type;

    @ManyToOne
    private Credit credit;
}
