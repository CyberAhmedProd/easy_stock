package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.MouvementStockApi;
import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.services.MouvementStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MouvementStockController implements MouvementStockApi {

    @Autowired
    private MouvementStockService mouvementStockService;

    @Override
    public MouvementSockDto save(MouvementSockDto mouvementStockDto) {
        return mouvementStockService.save(mouvementStockDto);
    }

    @Override
    public MouvementSockDto findById(Integer idMouvementStock) {
        return mouvementStockService.findById(idMouvementStock);
    }

    @Override
    public List<MouvementSockDto> findAll() {
        return mouvementStockService.findAll();
    }

    @Override
    public void delete(Integer idMouvementStock) {
        mouvementStockService.delete(idMouvementStock);
    }
}
