package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.MouvementStockApi;
import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.services.MouvementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MouvementStockController implements MouvementStockApi {

    @Autowired
    private MouvementStockService mouvementStockService;

    @Override
    public ResponseEntity<MouvementSockDto> save(MouvementSockDto mouvementStockDto) {
        return ResponseEntity.ok(mouvementStockService.save(mouvementStockDto));
    }

    @Override
    public ResponseEntity<MouvementSockDto> findById(Integer idMouvementStock) {
        return ResponseEntity.ok(mouvementStockService.findById(idMouvementStock));
    }

    @Override
    public ResponseEntity<List<MouvementSockDto>> findAll() {
        return ResponseEntity.ok(mouvementStockService.findAll());
    }

    @Override
    public void delete(Integer idMouvementStock) {
        mouvementStockService.delete(idMouvementStock);
    }
}
