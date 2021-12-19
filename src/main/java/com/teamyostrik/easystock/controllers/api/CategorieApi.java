package com.teamyostrik.easystock.controllers.api;
import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategorieApi {

    @PostMapping(value = Constants.APP_ROOT+"categorie/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CategorieDto save(@RequestBody CategorieDto categorieDto);
    @GetMapping(value = Constants.APP_ROOT+"categorie/{id_categorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CategorieDto getCategorieById(@PathVariable("id_categorie") Integer idCategorie);
    @GetMapping(value = Constants.APP_ROOT+"categorie/{code_categorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CategorieDto getCategorieByCode(@PathVariable("code_categorie") String codeCategorie);
    @GetMapping(value = Constants.APP_ROOT+"categorie/all")
    public List<CategorieDto> getAll();
    @DeleteMapping(value = Constants.APP_ROOT+"categorie/delete/{id_categorie}")
    public void delete(@PathVariable("id_categorie") Integer idCategorie);
}
