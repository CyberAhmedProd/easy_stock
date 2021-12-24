package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.UtilisateurDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(Constants.APP_ROOT + "utilisateurs")
public interface UtilisateurApi {
    @PostMapping(value = Constants.APP_ROOT+"utilisateur",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un utilisateur",notes = "Cette methode permet d'enregistrer ou modifier un utilisateur", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet utilisateur cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public UtilisateurDto create(@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = Constants.APP_ROOT+"utilisateur/{id_utilidateur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un utilisateur par ID",notes = "Cette methode permet rechercher un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'utilisateur est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "L'utilisateur n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public UtilisateurDto getById(@PathVariable("id_utilidateur") Integer idUtilisateur);

    @GetMapping(value = Constants.APP_ROOT+"utilisateur",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des utilisateurs",notes = "Cette methode permet de rechercher et renvoyer la liste des utilisateurs " +
            "qui existent dans la base des donnees", responseContainer = "List<UtilisateurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des utilisateurs / une liste vide")
    })
    public List<UtilisateurDto> getAll();

    @DeleteMapping(value = Constants.APP_ROOT+"utilisateur/{id_utilidateur}")
    @ApiOperation(value = "Supprimer un utilisateur",notes = "Cette methode permet de supprimer un utilisateur par son ID", response = UtilisateurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'utilisateur a ete supprimer")
    })
    public void delete(@PathVariable("id_utilidateur") Integer idUtilisateur);
}
