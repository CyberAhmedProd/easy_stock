package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.UtilisateurDto;
import com.teamyostrik.easystock.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UtilisateurApi {
    @PostMapping(value = Constants.APP_ROOT+"utilisateur/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurDto create(@RequestBody UtilisateurDto utilisateurDto);
    @GetMapping(value = Constants.APP_ROOT+"utilisateur/{id_utilidateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurDto getById(@PathVariable("id_utilidateur") Integer idUtilisateur);
    @GetMapping(value = Constants.APP_ROOT+"utilisateur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UtilisateurDto> getAll();
    @DeleteMapping(value = Constants.APP_ROOT+"utilisateur/delete/{id_utilidateur}")
    public void delete(@PathVariable("id_utilidateur") Integer idUtilisateur);
}
