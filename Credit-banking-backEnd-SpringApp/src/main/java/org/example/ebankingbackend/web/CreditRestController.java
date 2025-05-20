package org.example.ebankingbackend.web;

import lombok.AllArgsConstructor;
import org.example.ebankingbackend.dtos.*;
import org.example.ebankingbackend.services.CreditGlobalImplementation;
import org.example.ebankingbackend.services.CreditGlobalInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/credits")
@CrossOrigin("*")

public class CreditRestController {
    private final CreditGlobalInterface creditService;

    @GetMapping
    public List<CreditDTO> getCredits() {
        return creditService.listCredits();
    }

    @GetMapping("/{id}")
    public CreditDTO getCredit(@PathVariable Long id) {
        return creditService.getCredit(id);
    }

    @PostMapping("/personnel")
    public CreditPersonnelDTO saveCreditPersonnel(@RequestBody CreditPersonnelDTO dto) {
        return creditService.saveCreditPersonnel(dto);
    }

    @PostMapping("/professionnel")
    public CreditProfessionnelDTO saveCreditProfessionnel(@RequestBody CreditProfessionnelDTO dto) {
        return creditService.saveCreditProfessionnel(dto);
    }

    @PostMapping("/immobilier")
    public CreditImmobilierDTO saveCreditImmobilier(@RequestBody CreditImmobilierDTO dto) {
        return creditService.saveCreditImmobilier(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable Long id) {
        creditService.deleteCredit(id);
    }
}
