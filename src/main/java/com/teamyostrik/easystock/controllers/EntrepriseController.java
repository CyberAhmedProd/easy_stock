package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.EntrepriseApi;
import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {
    
    @Autowired
    private EntrepriseService entrepriseService;

    @Override
    public EntrepriseDto create(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto getById(Integer identreprise) {
        return entrepriseService.findById(identreprise);
    }

    @Override
    public List<EntrepriseDto> getAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer idEntreprise) {
        entrepriseService.delete(idEntreprise);
    }
}
