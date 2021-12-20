package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.FournisseurDto;
import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto fournisseurDto);
    FournisseurDto findById(Integer id);
    List<FournisseurDto> findAll();
    void delete(Integer id);
}
