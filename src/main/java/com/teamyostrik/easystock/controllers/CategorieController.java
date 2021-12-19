package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.CategorieApi;
import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {
    @Autowired
    private CategorieService categorieService;
    @Override
    public CategorieDto save(CategorieDto categorieDto) {
        return categorieService.save(categorieDto);
    }

    @Override
    public CategorieDto getCategorieById(Integer idCategorie) {
        return categorieService.findById(idCategorie);
    }

    @Override
    public CategorieDto getCategorieByCode(String codeCategorie) {
        return categorieService.findByCodeArticle(codeCategorie);
    }

    @Override
    public List<CategorieDto> getAll() {
        return categorieService.findAll();
    }

    @Override
    public void delete(Integer idCategorie) {
        categorieService.delete(idCategorie);
    }
}
