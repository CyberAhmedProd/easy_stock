package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.CommandeFournisseurApi;
import com.teamyostrik.easystock.dto.CommandeFournisseurDto;
import com.teamyostrik.easystock.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    @Autowired
    private CommandeFournisseurService commandeFournisseurService;

    @Override
    public ResponseEntity<CommandeFournisseurDto> save(CommandeFournisseurDto commandeFournisseurDto) {
        return ResponseEntity.ok(commandeFournisseurService.save(commandeFournisseurDto));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findById(Integer idCommandeFournisseur) {
        return ResponseEntity.ok(commandeFournisseurService.findById(idCommandeFournisseur));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDto> findByCodeCommande(String codeCommandeFournisseur) {
        return ResponseEntity.ok(commandeFournisseurService.findByCodeCommande(codeCommandeFournisseur));
    }

    @Override
    public ResponseEntity<List<CommandeFournisseurDto>> findAll() {
        return ResponseEntity.ok(commandeFournisseurService.findAll());
    }

    @Override
    public void delete(Integer idCommandeFournisseur) {
        commandeFournisseurService.delete(idCommandeFournisseur);
    }
}
