package com.teamyostrik.easystock.controllers.api;


import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.dto.CommandeFournisseurDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "commande_fournisseurs")
public interface CommandeFournisseurApi {

    @PostMapping(value = Constants.APP_ROOT+"commande_fournisseur",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une commande fournisseur",notes = "Cette methode permet d'enregistrer ou modifier une commande fournisseur", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet commande fournisseur cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);

    @GetMapping(value = Constants.APP_ROOT+"commande_fournisseur/{id_commande_fournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une commande fournisseur par ID",notes = "Cette methode permet rechercher une commande fournisseur par son ID", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande fournisseur est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La commande fournisseur n'existe pas dans la base des donnees avec l'ID fourni")
    })
    CommandeFournisseurDto findById(@PathVariable("id_commande_fournisseur") Integer idCommandeFournisseur);

    @GetMapping(value = Constants.APP_ROOT+"commande_fournisseur/{code_commande_fournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une commande fournisseur par Code",notes = "Cette methode permet de rechercher une commande fournisseur par son Code", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande fournisseur est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La commande fournisseur n'existe pas dans la base des donnees avec le code fourni")
    })
    CommandeFournisseurDto findByCodeCommande(@PathVariable("code_commande_fournisseur") String codeCommandeFournisseur);

    @GetMapping(value = Constants.APP_ROOT+"commande_fournisseur")
    @ApiOperation(value = "Renvoi la liste des commandes fournisseurs",notes = "Cette methode permet de rechercher et renvoyer la liste des commandes fournisseurs " +
            "qui existent dans la base des donnees", responseContainer = "List<CommandeFournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des commandes fournisseurs / une liste vide")
    })
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(value = Constants.APP_ROOT+"commande_fournisseur/{id_commande_fournisseur}")
    @ApiOperation(value = "Supprimer une commande fournisseur",notes = "Cette methode permet de supprimer une commande fournisseur par son ID", response = CommandeFournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande Fournisseur a ete supprimer")
    })
    void delete(@PathVariable("id_commande_fournisseur") Integer idCommandeFournisseur);
}
