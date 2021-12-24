package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.UtilisateurApi;
import com.teamyostrik.easystock.dto.UtilisateurDto;
import com.teamyostrik.easystock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {
    @Autowired
    private UtilisateurService utilisateurService;
    @Override
    public ResponseEntity<UtilisateurDto> create(UtilisateurDto utilisateurDto) {
        return ResponseEntity.ok(utilisateurService.save(utilisateurDto));
    }

    @Override
    public ResponseEntity<UtilisateurDto> getById(Integer idUtilisateur) {
        return ResponseEntity.ok(utilisateurService.findById(idUtilisateur));
    }

    @Override
    public ResponseEntity<List<UtilisateurDto>> getAll() {
        return ResponseEntity.ok(utilisateurService.findAll());
    }

    @Override
    public void delete(Integer idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
}
