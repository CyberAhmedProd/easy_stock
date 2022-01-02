package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.models.MouvementSock;

import java.math.BigDecimal;
import java.util.List;

public interface MouvementStockService {

    BigDecimal stockReelArticle(Integer idArticle);
    List<MouvementSockDto> mvtStockArticle(Integer idArticle);
    MouvementSockDto entreStock(MouvementSockDto mouvementSockDto);
    MouvementSockDto sortieStock(MouvementSockDto mouvementSockDto);
    MouvementSockDto correctionStockPositif(MouvementSockDto mouvementSockDto);
    MouvementSockDto correctionStockNegatif(MouvementSockDto mouvementSockDto);
    MouvementSockDto save(MouvementSockDto mouvementSockDto);
    MouvementSockDto findById(Integer id);
    List<MouvementSockDto> findAll();
    void delete(Integer id);
}
