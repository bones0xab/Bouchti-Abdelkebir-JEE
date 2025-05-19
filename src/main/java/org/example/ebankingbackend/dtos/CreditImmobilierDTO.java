package org.example.ebankingbackend.dtos;

import lombok.Data;
import org.example.ebankingbackend.enums.TypeBien;
@Data
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}
