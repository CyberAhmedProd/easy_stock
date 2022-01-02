package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.MouvementSockDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(Constants.APP_ROOT + "mouvement_stocks")
public interface MouvementStockApi {

    @GetMapping(value = Constants.APP_ROOT+"mouvement_stock/stock_reel/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche  un mouvement de stock d'un article par IDArticle et renvoie la somme de le la quantité",notes = "Cette methode permet rechercher  un mouvement de stock d'un article par IDArticle et renvoie la somme de le la quantité", response = BigDecimal.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la quantité est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "Le quantité n'existe pas dans la base des donnees avec l'ID article fourni")
    })
    BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = Constants.APP_ROOT+"mouvement_stock/filter/article/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des mouvements de stock par article",notes = "Cette methode permet de rechercher et renvoyer la liste des mouvements de stock par article" +
            "qui existent dans la base des donnees", responseContainer = "List<MouvementSockDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des mouvements de stock par article / une liste vide")
    })
    List<MouvementSockDto> mvtStockArticle(@PathVariable("idArticle") Integer idArticle);

    @PostMapping(value = Constants.APP_ROOT+"mouvement_stock/entree",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un mouvement de stock en entree",notes = "Cette methode permet d'enregistrer ou modifier un mouvement de stock en entree", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet mouvement de stock ene entree cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    MouvementSockDto entreStock(@RequestBody MouvementSockDto mouvementSockDto);

    @PostMapping(value = Constants.APP_ROOT+"mouvement_stock/sortie",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un mouvement de stock en sortie",notes = "Cette methode permet d'enregistrer ou modifier un mouvement de stock en sortie", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet mouvement de stock ene sortie cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    MouvementSockDto sortieStock(@RequestBody MouvementSockDto mouvementSockDto);

    @PostMapping(value = Constants.APP_ROOT+"mouvement_stock/correction_postive",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un mouvement de stock en correction positive",notes = "Cette methode permet d'enregistrer ou modifier un mouvement de stock en correction positive", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet mouvement de stock ene correction positive cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    MouvementSockDto correctionStockPositif(@RequestBody MouvementSockDto mouvementSockDto);

    @PostMapping(value = Constants.APP_ROOT+"mouvement_stock/correction_negative",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un mouvement de stock en correction negative",notes = "Cette methode permet d'enregistrer ou modifier un mouvement de stock en correction negative", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet mouvement de stock ene correction negative cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    MouvementSockDto correctionStockNegatif(@RequestBody MouvementSockDto mouvementSockDto);


    @PostMapping(value = Constants.APP_ROOT+"mouvement_stock",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un mouvement de stock",notes = "Cette methode permet d'enregistrer ou modifier un mouvement de stock", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet mouvement de stock cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public ResponseEntity<MouvementSockDto> save(@RequestBody MouvementSockDto mouvementStockDto);

    @GetMapping(value = Constants.APP_ROOT+"mouvement_stock/{id_mouvement_stock}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche  un mouvement de stock par ID",notes = "Cette methode permet rechercher  un mouvement de stock par son ID", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le mouvement de stock est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "Le mouvement de stock n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public ResponseEntity<MouvementSockDto> findById(@PathVariable("id_mouvement_stock") Integer idMouvementStock);

    @GetMapping(value = Constants.APP_ROOT+"mouvement_stock",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des mouvements de stock",notes = "Cette methode permet de rechercher et renvoyer la liste des mouvements de stock " +
            "qui existent dans la base des donnees", responseContainer = "List<MouvementSockDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des mouvements de stock / une liste vide")
    })
    public ResponseEntity<List<MouvementSockDto>> findAll();

    @DeleteMapping(value = Constants.APP_ROOT+"mouvement_stock/{id_mouvement_stock}")
    @ApiOperation(value = "Supprimer un mouvement de stock",notes = "Cette methode permet de supprimer un mouvement de stock par son ID", response = MouvementSockDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le mouvement de stock a ete supprimer")
    })
    void delete(@PathVariable("id_mouvement_stock") Integer idMouvementStock);
}
