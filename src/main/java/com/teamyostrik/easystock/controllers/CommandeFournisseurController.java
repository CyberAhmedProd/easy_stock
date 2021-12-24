package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.CommandeFournisseurApi;
import com.teamyostrik.easystock.dto.CommandeFournisseurDto;
import com.teamyostrik.easystock.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    @Autowired
    private CommandeFournisseurService commandeFournisseurService;

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        return commandeFournisseurService.save(commandeFournisseurDto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer idCommandeFournisseur) {
        return commandeFournisseurService.findById(idCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findByCodeCommande(String codeCommandeFournisseur) {
        return commandeFournisseurService.findByCodeCommande(codeCommandeFournisseur);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Integer idCommandeFournisseur) {
        commandeFournisseurService.delete(idCommandeFournisseur);
    }
}
