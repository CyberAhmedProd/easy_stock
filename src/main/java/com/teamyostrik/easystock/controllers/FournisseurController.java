package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.FournisseurApi;
import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {
    @Autowired
    private FournisseurService fournisseurService;
    @Override
    public ResponseEntity<FournisseurDto> create(FournisseurDto fournisseur) {
        return ResponseEntity.ok(fournisseurService.save(fournisseur));
    }

    @Override
    public ResponseEntity<FournisseurDto> getById(Integer idFournisseur) {
        return ResponseEntity.ok(fournisseurService.findById(idFournisseur));
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> getAll() {
        return
                ResponseEntity.ok(fournisseurService.findAll());
    }

    @Override
    public void delete(Integer idFournisseur) {
        fournisseurService.delete(idFournisseur);
    }
}
