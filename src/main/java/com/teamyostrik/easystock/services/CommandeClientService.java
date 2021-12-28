package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.dto.LigneCommandeClientDto;
import com.teamyostrik.easystock.models.CommandeClient;
import com.teamyostrik.easystock.models.EtatCommande;
import com.teamyostrik.easystock.models.LigneCommandeClient;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto commandeClientDto);
    CommandeClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande);
    CommandeClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, float quantite);
    CommandeClientDto updateClient(Integer idCommande, Integer idClient);
    CommandeClientDto updateArticle(Integer idCommande, Integer idLigneCommande,Integer idArticle);
    // Delete article ==> Delete LigneCommande
    CommandeClientDto deleteArticle(Integer idCommande,Integer idLigneCommande);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCodeCommande(String codeCommandeClient);
    List<CommandeClientDto> findAll();
    List<LigneCommandeClientDto> findAllLignesCommandesByCommandeClientId(Integer idCommande);
    void delete(Integer id);
}
