package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.CategorieDto;
import java.util.List;

public interface CategorieService {

    CategorieDto save(CategorieDto categorieDto);
    CategorieDto findById(Integer id);
    CategorieDto findByCodeArticle(String codeCategorie);
    List<CategorieDto> findAll();
    void delete(Integer id);
}
