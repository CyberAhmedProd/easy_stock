package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.UtilisateurDto;
import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto utilisateurDto);
    UtilisateurDto findById(Integer id);
    List<UtilisateurDto> findAll();
    void delete(Integer id);
}

