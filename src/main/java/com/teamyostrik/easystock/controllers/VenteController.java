package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.VenteApi;
import com.teamyostrik.easystock.dto.VenteDto;
import com.teamyostrik.easystock.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {

    @Autowired
    private VenteService venteService;

    @Override
    public VenteDto save(VenteDto venteDto) {
        return venteService.save(venteDto);
    }

    @Override
    public VenteDto getVenteById(Integer idVente) {
        return venteService.getVenteById(idVente);
    }

    @Override
    public VenteDto getVenteByCode(String codeVente) {
        return venteService.getVenteByCode(codeVente);
    }

    @Override
    public List<VenteDto> getAll() {
        return venteService.getAll();
    }

    @Override
    public void delete(Integer idVente) {
        venteService.delete(idVente);
    }
}
