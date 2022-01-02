package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.ChangerMotDePassUtilisateurDto;
import com.teamyostrik.easystock.dto.UtilisateurDto;
import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto utilisateurDto);
    UtilisateurDto findById(Integer id);
    List<UtilisateurDto> findAll();
    void delete(Integer id);
    UtilisateurDto findByEmail(String email);
    UtilisateurDto changerMotDePasse(ChangerMotDePassUtilisateurDto changerMotDePassUtilisateurDto);

}

