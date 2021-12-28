package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.CommandeClientApi;
import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.models.EtatCommande;
import com.teamyostrik.easystock.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CommandeClientController implements CommandeClientApi {
    @Autowired
    private CommandeClientService commandeClientService;
    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
        return ResponseEntity.ok(commandeClientService.save(commandeClientDto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> save(Integer idCommande, EtatCommande etatCommande) {
        return ResponseEntity.ok(commandeClientService.updateEtatCommande(idCommande,etatCommande));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer IdCommandeClient) {
        return ResponseEntity.ok(commandeClientService.findById(IdCommandeClient));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCodeCommande(String codeCommandeClient) {
        return ResponseEntity.ok(commandeClientService.findByCodeCommande(codeCommandeClient));
    }

    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {

        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public void delete(Integer idCommandeClient) {
        commandeClientService.delete(idCommandeClient);

    }
}
