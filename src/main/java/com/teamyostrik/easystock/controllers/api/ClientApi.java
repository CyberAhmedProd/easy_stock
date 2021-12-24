package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.ClientDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "clients")
public interface ClientApi {
    @PostMapping(value = Constants.APP_ROOT+"client",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un client",notes = "Cette methode permet d'enregistrer ou modifier un client", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public ClientDto create(@RequestBody ClientDto client);

    @GetMapping(value = Constants.APP_ROOT+"client/{id_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un client par ID",notes = "Cette methode permet rechercher un client par son ID", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "Le client n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public ClientDto getById(@PathVariable("id_client") Integer id);

    @GetMapping(value = Constants.APP_ROOT+"client",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des clients",notes = "Cette methode permet de rechercher et renvoyer la liste des clients " +
            "qui existent dans la base des donnees", responseContainer = "List<ClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des clients / une liste vide")
    })
    public List<ClientDto> getAll();

    @DeleteMapping(value = Constants.APP_ROOT+"client/{id_client}")
    @ApiOperation(value = "Supprimer un client",notes = "Cette methode permet de supprimer un client par son ID", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client a ete supprimer")
    })
    public void delete(@PathVariable("id_client") Integer idClient);
}
