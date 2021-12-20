package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.FournisseurApi;
import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {
    @Autowired
    private FournisseurService fournisseurService;
    @Override
    public FournisseurDto create(FournisseurDto fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @Override
    public FournisseurDto getById(Integer idFournisseur) {
        return fournisseurService.findById(idFournisseur);
    }

    @Override
    public List<FournisseurDto> getAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer idFournisseur) {
        fournisseurService.delete(idFournisseur);
    }
}
