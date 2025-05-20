package org.example.ebankingbackend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ebankingbackend.dtos.*;
import org.example.ebankingbackend.entities.*;
import org.example.ebankingbackend.mappers.CreditMapperImpl;
import org.example.ebankingbackend.repositories.ClientRepository;
import org.example.ebankingbackend.repositories.CreditRepository;
import org.example.ebankingbackend.repositories.RemboursementRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditGlobalImplementation implements CreditGlobalInterface {

    private final ClientRepository clientRepository;
    private final CreditRepository creditRepository;
    private final RemboursementRepository remboursementRepository;
    private final CreditMapperImpl mapper;

    // Client CRUD
    @Override
    public ClientDTO saveClient(ClientDTO dto) {
        Client client = mapper.fromClientDTO(dto);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClient(Long id) {
        return clientRepository.findById(id)
                .map(mapper::fromClient)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public ClientDTO updateClient(ClientDTO dto) {
        Client client = mapper.fromClientDTO(dto);
        return mapper.fromClient(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    // Credit CRUD
    @Override
    public CreditDTO saveCredit(CreditDTO dto) {
        Credit credit = mapper.fromCreditDTO(dto);
        return mapper.fromCredit(creditRepository.save(credit));
    }

    @Override
    public CreditDTO getCredit(Long id) {
        return creditRepository.findById(id)
                .map(mapper::fromCredit)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
    }

    @Override
    public CreditDTO updateCredit(CreditDTO dto) {
        Credit credit = mapper.fromCreditDTO(dto);
        return mapper.fromCredit(creditRepository.save(credit));
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> getCreditsByClientId(Long clientId) {
        return creditRepository.findByClientId(clientId).stream()
                .map(mapper::fromCredit)
                .collect(Collectors.toList());
    }

    // Remboursement CRUD
    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = mapper.fromRemboursementDTO(dto);
        return mapper.fromRemboursement(remboursementRepository.save(remboursement));
    }

    @Override
    public RemboursementDTO getRemboursement(Long id) {
        return remboursementRepository.findById(id)
                .map(mapper::fromRemboursement)
                .orElseThrow(() -> new RuntimeException("Remboursement not found"));
    }

    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = mapper.fromRemboursementDTO(dto);
        return mapper.fromRemboursement(remboursementRepository.save(remboursement));
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByCreditId(Long creditId) {
        return remboursementRepository.findByCreditId(creditId).stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public List<RemboursementDTO> listRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(mapper::fromRemboursement)
                .collect(Collectors.toList());
    }
    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto) {
        CreditPersonnel entity = mapper.fromCreditPersonnelDTO(dto);
        Credit saved = creditRepository.save(entity);
        return mapper.fromCreditPersonnel((CreditPersonnel) saved);
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto) {
        CreditProfessionnel entity = mapper.fromCreditProfessionnelDTO(dto);
        Credit saved = creditRepository.save(entity);
        return mapper.fromCreditProfessionnel((CreditProfessionnel) saved);
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto) {
        CreditImmobilier entity = mapper.fromCreditImmobilierDTO(dto);
        Credit saved = creditRepository.save(entity);
        return mapper.fromCreditImmobilier((CreditImmobilier) saved);
    }

}