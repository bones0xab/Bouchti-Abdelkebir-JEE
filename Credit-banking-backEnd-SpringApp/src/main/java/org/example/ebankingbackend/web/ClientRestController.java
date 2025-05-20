package org.example.ebankingbackend.web;

import lombok.AllArgsConstructor;
import org.example.ebankingbackend.dtos.ClientDTO;
import org.example.ebankingbackend.services.CreditGlobalImplementation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
@CrossOrigin("*")

public class ClientRestController {

    private final CreditGlobalImplementation creditService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return creditService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return creditService.getClient(id);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return creditService.saveClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        creditService.deleteClient(id);
    }
}
