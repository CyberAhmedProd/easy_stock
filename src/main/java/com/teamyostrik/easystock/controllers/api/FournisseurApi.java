package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface FournisseurApi {

    @PostMapping(value = Constants.APP_ROOT+"fournisseur/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public FournisseurDto create(@RequestBody FournisseurDto fournisseur);
    @GetMapping(value = Constants.APP_ROOT+"fournisseur/{id_fournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FournisseurDto getById(@PathVariable("id_fournisseur") Integer idFournisseur);
    @GetMapping(value = Constants.APP_ROOT+"fournisseur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FournisseurDto> getAll();
    @DeleteMapping(value = Constants.APP_ROOT+"fournisseur/delete/{id_fournisseur}")
    public void delete(@PathVariable("id_fournisseur") Integer idFournisseur);
}
