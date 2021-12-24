package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.CategorieApi;
import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CategorieController implements CategorieApi {
    @Autowired
    private CategorieService categorieService;
    @Override
    public ResponseEntity<CategorieDto> save(CategorieDto categorieDto) {

        return ResponseEntity.ok(categorieService.save(categorieDto));
    }

    @Override
    public ResponseEntity<CategorieDto> getCategorieById(Integer idCategorie) {
        return ResponseEntity.ok(categorieService.findById(idCategorie));
    }

    @Override
    public ResponseEntity<CategorieDto> getCategorieByCode(String codeCategorie) {
        return ResponseEntity.ok(categorieService.findByCodeArticle(codeCategorie));
    }

    @Override
    public ResponseEntity<List<CategorieDto>> getAll()
    {
        return ResponseEntity.ok(categorieService.findAll());
    }

    @Override
    public void delete(Integer idCategorie) {
        categorieService.delete(idCategorie);
    }
}
