package org.example.ebankingbackend.mappers;

import org.example.ebankingbackend.dtos.*;

import org.example.ebankingbackend.entities.*;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapperImpl {
    // Client <-> ClientDTO
    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    // Credit <-> CreditDTO
    public CreditDTO fromCredit(Credit credit) {
        CreditDTO creditDTO = new CreditDTO();
        BeanUtils.copyProperties(credit, creditDTO);
        return creditDTO;
    }

    public Credit fromCreditDTO(CreditDTO creditDTO) {
        Credit credit = new Credit();
        BeanUtils.copyProperties(creditDTO, credit);
        return credit;
    }

    // CreditPersonnel <-> CreditPersonnelDTO
    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(creditPersonnel, dto);
        return dto;
    }

    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO dto) {
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        BeanUtils.copyProperties(dto, creditPersonnel);
        return creditPersonnel;
    }

    // CreditImmobilier <-> CreditImmobilierDTO
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier, dto);
        return dto;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO dto) {
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        BeanUtils.copyProperties(dto, creditImmobilier);
        return creditImmobilier;
    }

    // CreditProfessionnel <-> CreditProfessionnelDTO
    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel creditProfessionnel) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(creditProfessionnel, dto);
        return dto;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO dto) {
        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, creditProfessionnel);
        return creditProfessionnel;
    }

    // Remboursement <-> RemboursementDTO
    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        return dto;
    }

    public Remboursement fromRemboursementDTO(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        BeanUtils.copyProperties(dto, remboursement);
        return remboursement;
    }
}
