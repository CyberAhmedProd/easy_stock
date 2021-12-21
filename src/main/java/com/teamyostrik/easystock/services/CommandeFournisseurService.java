package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.CommandeFournisseurDto;
import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);
    CommandeFournisseurDto findById(Integer id);
    CommandeFournisseurDto findByCodeCommande(String codeCommandeFournisseur);
    List<CommandeFournisseurDto> findAll();
    void delete(Integer id);
}
