package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.EntrepriseApi;
import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {

    @Autowired
    private EntrepriseService entrepriseService;

    @Override
    public ResponseEntity<EntrepriseDto> create(EntrepriseDto entrepriseDto) {
        return ResponseEntity.ok(entrepriseService.save(entrepriseDto));
    }

    @Override
    public ResponseEntity<EntrepriseDto> getById(Integer identreprise) {
        return ResponseEntity.ok(entrepriseService.findById(identreprise));
    }

    @Override
    public ResponseEntity<List<EntrepriseDto>> getAll() {
        return ResponseEntity.ok(entrepriseService.findAll());
    }

    @Override
    public void delete(Integer idEntreprise) {
        entrepriseService.delete(idEntreprise);
    }
}
