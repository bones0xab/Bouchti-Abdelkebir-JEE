package org.example.ebankingbackend.dtos;

import lombok.Data;
import org.example.ebankingbackend.enums.TypeRemboursement;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private BigDecimal montant;
    private TypeRemboursement type;
    private Long creditId;
}
