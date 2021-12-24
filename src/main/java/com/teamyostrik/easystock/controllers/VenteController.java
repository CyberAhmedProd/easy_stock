package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.VenteApi;
import com.teamyostrik.easystock.dto.VenteDto;
import com.teamyostrik.easystock.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {

    @Autowired
    private VenteService venteService;

    @Override
    public ResponseEntity<VenteDto> save(VenteDto venteDto) {
        return ResponseEntity.ok(venteService.save(venteDto));
    }

    @Override
    public ResponseEntity<VenteDto> getVenteById(Integer idVente) {
        return ResponseEntity.ok(venteService.getVenteById(idVente));
    }

    @Override
    public ResponseEntity<VenteDto> getVenteByCode(String codeVente) {
        return ResponseEntity.ok(venteService.getVenteByCode(codeVente));
    }

    @Override
    public ResponseEntity<List<VenteDto>> getAll() {
        return ResponseEntity.ok(venteService.getAll());
    }

    @Override
    public void delete(Integer idVente) {
        venteService.delete(idVente);
    }
}
