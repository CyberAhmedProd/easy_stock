package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(Constants.APP_ROOT + "commande_clients")
public interface CommandeClientApi {
    @PostMapping(value = Constants.APP_ROOT+"commande_client",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une commande client",notes = "Cette methode permet d'enregistrer ou modifier une commande client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet commande client cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    CommandeClientDto save(@RequestBody CommandeClientDto commandeClientDto);


    @GetMapping(value = Constants.APP_ROOT+"commande_client/{id_commande_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une commande client par ID",notes = "Cette methode permet rechercher une commande client par son ID", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande client est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La commande client n'existe pas dans la base des donnees avec l'ID fourni")
    })
    CommandeClientDto findById(@PathVariable("id_commande_client") Integer IdCommandeClient);

    @GetMapping(value = Constants.APP_ROOT+"commande_client/{code_commande_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une commande client par Code",notes = "Cette methode permet de rechercher une commande client par son Code", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande client est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La commande client n'existe pas dans la base des donnees avec le code fourni")
    })
    CommandeClientDto findByCodeCommande(@PathVariable("code_commande_client") String codeCommandeClient);

    @GetMapping(value = Constants.APP_ROOT+"commande_client")
    @ApiOperation(value = "Renvoi la liste des commandes clients",notes = "Cette methode permet de rechercher et renvoyer la liste des commandes clients " +
            "qui existent dans la base des donnees", responseContainer = "List<CommandeClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des commandes clients / une liste vide")
    })
    List<CommandeClientDto> findAll();

    @DeleteMapping(value = Constants.APP_ROOT+"commande_client/{id_commande_client}")
    @ApiOperation(value = "Supprimer une commande client",notes = "Cette methode permet de supprimer une commande client par son ID", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a ete supprimer")
    })
    void delete(@PathVariable("id_commande_client") Integer idCommandeClient);
}
