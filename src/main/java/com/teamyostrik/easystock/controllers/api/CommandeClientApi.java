package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.CommandeClientDto;
import com.teamyostrik.easystock.models.EtatCommande;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);

    @PatchMapping(value = Constants.APP_ROOT+"commande_client/{id_commande}/{etat_commande}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Metre à jour l'état d'une commande client",notes = "Cette methode permet de metre à jour létat d'une commande client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet état commande client modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    ResponseEntity<CommandeClientDto> updateEtatCommande(@PathVariable("id_commande") Integer idCommande, @PathVariable("etat_commande") EtatCommande etatCommande);


    @PatchMapping(value = Constants.APP_ROOT+"commande_client/{id_commande}/{id_ligne_commande}/{quantite}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Metre à jour la quantité de la ligne commande d'une commande client",notes = "Cette methode permet de metre à jour la quantite d'une ligne commane d'une commande client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet quantite ligne commande client modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(@PathVariable("id_commande") Integer idCommande, @PathVariable("id_ligne_commande") Integer idLigneCommande,@PathVariable("quantite") float quantite);

    @PatchMapping(value = Constants.APP_ROOT+"commande_client/{id_commande}/{id_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Metre à jour le client d'une commande client",notes = "Cette methode permet de metre à jour le client d'une commande client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client de la  commande client modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    ResponseEntity<CommandeClientDto> updateClientCommande(@PathVariable("id_commande") Integer idCommande, @PathVariable("id_client") Integer idClient);


    @PatchMapping(value = Constants.APP_ROOT+"commande_client/{id_commande}/{id_ligne_commande}/{id_article}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Metre à jour une article dans la ligne commande d'une commande client",notes = "Cette methode permet de metre à jour un article d'une ligne commane d'une commande client", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article ligne commande client modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    ResponseEntity<CommandeClientDto> updateArticleCommande(@PathVariable("id_commande") Integer idCommande, @PathVariable("id_ligne_commande") Integer idLigneCommande,@PathVariable("id_article") Integer idArticle);

    @DeleteMapping(value = Constants.APP_ROOT+"commande_client/{id_commande}/{id_ligne_commande}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Suppression d'un article d'une commande client dans une ligne de commande",notes = "Cette methode permet de supprimer un article d'une commande client dans une ligne de commande", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article commande client supprimé"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    ResponseEntity<CommandeClientDto> deleteArticleCommande(@PathVariable("id_commande") Integer idCommande, @PathVariable("id_ligne_commande") Integer idLigneCommande);


    @GetMapping(value = Constants.APP_ROOT+"commande_client/{id_commande_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une commande client par ID",notes = "Cette methode permet rechercher une commande client par son ID", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande client est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La commande client n'existe pas dans la base des donnees avec l'ID fourni")
    })
    ResponseEntity<CommandeClientDto> findById(@PathVariable("id_commande_client") Integer IdCommandeClient);

    @GetMapping(value = Constants.APP_ROOT+"commande_client/{code_commande_client}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une commande client par Code",notes = "Cette methode permet de rechercher une commande client par son Code", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande client est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La commande client n'existe pas dans la base des donnees avec le code fourni")
    })
    ResponseEntity<CommandeClientDto> findByCodeCommande(@PathVariable("code_commande_client") String codeCommandeClient);

    @GetMapping(value = Constants.APP_ROOT+"commande_client")
    @ApiOperation(value = "Renvoi la liste des commandes clients",notes = "Cette methode permet de rechercher et renvoyer la liste des commandes clients " +
            "qui existent dans la base des donnees", responseContainer = "List<CommandeClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des commandes clients / une liste vide")
    })
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(value = Constants.APP_ROOT+"commande_client/{id_commande_client}")
    @ApiOperation(value = "Supprimer une commande client",notes = "Cette methode permet de supprimer une commande client par son ID", response = CommandeClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La commande fournisseur a ete supprimer")
    })
    public void delete(@PathVariable("id_commande_client") Integer idCommandeClient);
}
