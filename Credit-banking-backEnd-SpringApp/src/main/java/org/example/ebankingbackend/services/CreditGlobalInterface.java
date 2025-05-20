package org.example.ebankingbackend.services;

import org.example.ebankingbackend.dtos.*;

import java.util.List;

public interface CreditGlobalInterface {
    // Client
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long id);
    List<ClientDTO> listClients();

    // Credit
    CreditDTO saveCredit(CreditDTO creditDTO);
    CreditDTO getCredit(Long id);
    CreditDTO updateCredit(CreditDTO creditDTO);
    void deleteCredit(Long id);
    List<CreditDTO> listCredits();
    List<CreditDTO> getCreditsByClientId(Long clientId);
    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO dto);
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO dto);
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO dto);


    // Remboursement
    RemboursementDTO saveRemboursement(RemboursementDTO dto);
    RemboursementDTO getRemboursement(Long id);
    RemboursementDTO updateRemboursement(RemboursementDTO dto);
    void deleteRemboursement(Long id);
    List<RemboursementDTO> getRemboursementsByCreditId(Long creditId);
    List<RemboursementDTO> listRemboursements();
}
