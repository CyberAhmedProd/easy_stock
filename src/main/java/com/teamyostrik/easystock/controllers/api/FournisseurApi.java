package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.FournisseurDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Api(Constants.APP_ROOT + "/fournisseurs")
public interface FournisseurApi {

    @PostMapping(value = Constants.APP_ROOT+"fournisseur/create",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un fournisseur",notes = "Cette methode permet d'enregistrer ou modifier un fournisseur", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet fournisseur cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public FournisseurDto create(@RequestBody FournisseurDto fournisseur);

    @GetMapping(value = Constants.APP_ROOT+"fournisseur/{id_fournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un fournisseur par ID",notes = "Cette methode permet rechercher un fournisseur par son ID", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "Le fournisseur n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public FournisseurDto getById(@PathVariable("id_fournisseur") Integer idFournisseur);

    @GetMapping(value = Constants.APP_ROOT+"fournisseur/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des fournisseurs",notes = "Cette methode permet de rechercher et renvoyer la liste des fournisseurs " +
            "qui existent dans la base des donnees", responseContainer = "List<FournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des fournisseurs / une liste vide")
    })
    public List<FournisseurDto> getAll();
    @DeleteMapping(value = Constants.APP_ROOT+"fournisseur/delete/{id_fournisseur}")
    @ApiOperation(value = "Supprimer un fournisseur",notes = "Cette methode permet de supprimer un fournisseur par son ID", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le fournisseur a ete supprimer")
    })
    public void delete(@PathVariable("id_fournisseur") Integer idFournisseur);
}
