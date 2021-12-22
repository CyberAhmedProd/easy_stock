package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.MouvementSockDto;
import java.util.List;

public interface MouvementStockService {

    MouvementSockDto save(MouvementSockDto mouvementSockDto);
    MouvementSockDto findById(Integer id);
    List<MouvementSockDto> findAll();
    void delete(Integer id);
}
