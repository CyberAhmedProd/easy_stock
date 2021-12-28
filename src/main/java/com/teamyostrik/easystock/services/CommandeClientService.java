package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.models.EtatCommande;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
    CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, float quantite);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCodeCommande(String codeCommandeClient);
    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
