package org.example.ebankingbackend.web;

import lombok.AllArgsConstructor;
import org.example.ebankingbackend.dtos.RemboursementDTO;
import org.example.ebankingbackend.services.CreditGlobalImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/remboursements")
@CrossOrigin("*")
public class RemboursementRestController {
    private final CreditGlobalImplementation creditService;

    @GetMapping
    public List<RemboursementDTO> getRemboursements() {
        return creditService.listRemboursements();
    }

    @GetMapping("/{id}")
    public RemboursementDTO getRemboursement(@PathVariable Long id) {
        return creditService.getRemboursement(id);
    }

    @PostMapping
    public RemboursementDTO saveRemboursement(@RequestBody RemboursementDTO dto) {
        return creditService.saveRemboursement(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRemboursement(@PathVariable Long id) {
        creditService.deleteRemboursement(id);
    }
}
