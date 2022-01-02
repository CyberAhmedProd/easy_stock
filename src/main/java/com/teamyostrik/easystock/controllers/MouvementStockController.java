package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.MouvementStockApi;
import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.services.MouvementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MouvementStockController implements MouvementStockApi {

    @Autowired
    private MouvementStockService mouvementStockService;

    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        return mouvementStockService.stockReelArticle(idArticle);
    }

    @Override
    public List<MouvementSockDto> mvtStockArticle(Integer idArticle) {
        return mouvementStockService.mvtStockArticle(idArticle);
    }

    @Override
    public MouvementSockDto entreStock(MouvementSockDto mouvementSockDto) {
        return mouvementStockService.entreStock(mouvementSockDto);
    }

    @Override
    public MouvementSockDto sortieStock(MouvementSockDto mouvementSockDto) {
        return mouvementStockService.sortieStock(mouvementSockDto);
    }

    @Override
    public MouvementSockDto correctionStockPositif(MouvementSockDto mouvementSockDto) {
        return mouvementStockService.correctionStockPositif(mouvementSockDto);
    }

    @Override
    public MouvementSockDto correctionStockNegatif(MouvementSockDto mouvementSockDto) {
        return mouvementStockService.correctionStockNegatif(mouvementSockDto);
    }

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
