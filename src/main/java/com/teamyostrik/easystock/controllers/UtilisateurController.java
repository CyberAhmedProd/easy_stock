package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.UtilisateurApi;
import com.teamyostrik.easystock.dto.UtilisateurDto;
import com.teamyostrik.easystock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {
    @Autowired
    private UtilisateurService utilisateurService;
    @Override
    public UtilisateurDto create(UtilisateurDto utilisateurDto) {
        return utilisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto getById(Integer idUtilisateur) {
        return utilisateurService.findById(idUtilisateur);
    }

    @Override
    public List<UtilisateurDto> getAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
}
