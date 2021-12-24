package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EntrepriseApi {

    @PostMapping(value = Constants.APP_ROOT+"entreprise/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une entreprise",notes = "Cette methode permet d'enregistrer ou modifier une entreprise", response = EntrepriseApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public EntrepriseDto create(@RequestBody EntrepriseDto entrepriseDto);

    @GetMapping(value = Constants.APP_ROOT+"entreprise/{id_entreprise}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une entreprise par ID",notes = "Cette methode permet rechercher une entreprise par son ID", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'entreprise est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "L'entreprise n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public EntrepriseDto getById(@PathVariable("id_entreprise") Integer identreprise);

    @GetMapping(value = Constants.APP_ROOT+"entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des entreprises",notes = "Cette methode permet de rechercher et renvoyer la liste des entreprises " +
            "qui existent dans la base des donnees", responseContainer = "List<EntrepriseDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des entreprises / une liste vide")
    })
    public List<EntrepriseDto> getAll();

    @DeleteMapping(value = Constants.APP_ROOT+"entreprise/delete/{id_entreprise}")
    @ApiOperation(value = "Supprimer une entreprise",notes = "Cette methode permet de supprimer une entreprise par son ID", response = EntrepriseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'entreprise a ete supprimer")
    })
    public void delete(@PathVariable("id_entreprise") Integer idEntreprise);
}
