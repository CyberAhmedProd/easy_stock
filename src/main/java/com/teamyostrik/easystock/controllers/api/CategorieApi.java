package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(Constants.APP_ROOT + "categories")
public interface CategorieApi {

    @PostMapping(value = Constants.APP_ROOT+"categorie",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une categorie",notes = "Cette methode permet d'enregistrer ou modifier une categorie", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet categorie cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public ResponseEntity<CategorieDto> save(@RequestBody CategorieDto categorieDto);

    @GetMapping(value = Constants.APP_ROOT+"categorie/{id_categorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une categorie par ID",notes = "Cette methode permet rechercher une categorie par son ID", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La categorie n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public ResponseEntity<CategorieDto> getCategorieById(@PathVariable("id_categorie") Integer idCategorie);

    @GetMapping(value = Constants.APP_ROOT+"categorie/{code_categorie}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une categorie par Code",notes = "Cette methode permet de rechercher une categorie par son Code", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La categorie n'existe pas dans la base des donnees avec le code fourni")
    })
    public ResponseEntity<CategorieDto> getCategorieByCode(@PathVariable("code_categorie") String codeCategorie);

    @GetMapping(value = Constants.APP_ROOT+"categorie")
    @ApiOperation(value = "Renvoi la liste des categories",notes = "Cette methode permet de rechercher et renvoyer la liste des categories " +
            "qui existent dans la base des donnees", responseContainer = "List<CategorieDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des categories / une liste vide")
    })
    public ResponseEntity<List<CategorieDto>> getAll();

    @DeleteMapping(value = Constants.APP_ROOT+"categorie/{id_categorie}")
    @ApiOperation(value = "Supprimer une categorie",notes = "Cette methode permet de supprimer une categorie par son ID", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La categorie a ete supprimer")
    })
    public void delete(@PathVariable("id_categorie") Integer idCategorie);
}
