package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EntrepriseApi {

    @PostMapping(value = Constants.APP_ROOT+"entreprise/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public EntrepriseDto create(@RequestBody EntrepriseDto entrepriseDto);
    @GetMapping(value = Constants.APP_ROOT+"entreprise/{id_entreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EntrepriseDto getById(@PathVariable("id_entreprise") Integer identreprise);
    @GetMapping(value = Constants.APP_ROOT+"entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EntrepriseDto> getAll();
    @DeleteMapping(value = Constants.APP_ROOT+"entreprise/delete/{id_entreprise}")
    public void delete(@PathVariable("id_entreprise") Integer idEntreprise);
}
