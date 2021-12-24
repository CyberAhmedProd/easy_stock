package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.VenteDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(Constants.APP_ROOT + "ventes")
public interface VenteApi {

    @PostMapping(value = Constants.APP_ROOT+"vente",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une vente",notes = "Cette methode permet d'enregistrer ou modifier une vente", response = VenteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet vente cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public VenteDto save(@RequestBody VenteDto venteDto);

    @GetMapping(value = Constants.APP_ROOT+"vente/{id_vente}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une vente par ID",notes = "Cette methode permet rechercher une vente par son ID", response = VenteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La vente est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La vente n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public VenteDto getVenteById(@PathVariable("id_vente") Integer idVente);

    @GetMapping(value = Constants.APP_ROOT+"vente/{code_vente}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche une vente par Code",notes = "Cette methode permet de rechercher une vente par son Code", response = VenteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La vente est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "La vente n'existe pas dans la base des donnees avec le code fourni")
    })
    public VenteDto getVenteByCode(@PathVariable("code_vente") String codeVente);

    @GetMapping(value = Constants.APP_ROOT+"vente")
    @ApiOperation(value = "Renvoi la liste des ventes",notes = "Cette methode permet de rechercher et renvoyer la liste des ventes " +
            "qui existent dans la base des donnees", responseContainer = "List<VenteDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des ventes / une liste vide")
    })
    public List<VenteDto> getAll();

    @DeleteMapping(value = Constants.APP_ROOT+"vente/{id_vente}")
    @ApiOperation(value = "Supprimer une vente",notes = "Cette methode permet de supprimer une vente par son ID", response = VenteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La vente a ete supprimer")
    })
    public void delete(@PathVariable("id_vente") Integer idVente);
}
