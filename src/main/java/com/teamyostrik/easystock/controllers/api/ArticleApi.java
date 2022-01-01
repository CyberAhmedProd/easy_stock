package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.dto.LigneCommandeClientDto;
import com.teamyostrik.easystock.dto.LigneCommandeFournisseurDto;
import com.teamyostrik.easystock.dto.LigneVenteDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(Constants.APP_ROOT + "articles")
public interface ArticleApi {

    @PostMapping(value = Constants.APP_ROOT+"article",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article",notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public ResponseEntity<ArticleDto> save(@RequestBody ArticleDto article);

    @GetMapping(value = Constants.APP_ROOT+"article/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un article par ID",notes = "Cette methode permet rechercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "L'article n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable("id_article") Integer idArticle);

    @GetMapping(value = Constants.APP_ROOT+"article/{code_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un article par Code",notes = "Cette methode permet de rechercher un article par son Code", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "L'article n'existe pas dans la base des donnees avec le code fourni")
    })
    public ResponseEntity<ArticleDto> getArticleByCode(@PathVariable("code_article") String codeArticle);

    @GetMapping(value = Constants.APP_ROOT+"article", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles",notes = "Cette methode permet de rechercher et renvoyer la liste des articles " +
            "qui existent dans la base des donnees", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des articles / une liste vide")
    })
    public ResponseEntity<List<ArticleDto>> getAll();

    @GetMapping(value = Constants.APP_ROOT+"article/historique/vente/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi l'historique des ventes d'un article",notes = "Cette methode permet de rechercher et renvoyer la liste des ventes de l'article " +
            "qui existent dans la base des donnees", responseContainer = "List<LigneVenteDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'Historique des ventes / une liste vide")
    })
    List<LigneVenteDto> findHistoryVentes(@PathVariable("id_article") Integer idArticle);

    @GetMapping(value = Constants.APP_ROOT+"article/historique/commande_client/{id_Article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi l'historique des commandes client d'un article",notes = "Cette methode permet de rechercher et renvoyer la liste des commandes clients" +
            " d'un article qui existent dans la base des donnees", responseContainer = "List<LigneCommandeClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des commandes clients / une liste vide")
    })
    List<LigneCommandeClientDto> findHistoryCommandeCLient(@PathVariable("id_Article") Integer idArticle);

    @GetMapping(value = Constants.APP_ROOT+"article/historique/commande_fournisseur/{id_Article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi l'historique des commandes fournisseur d'un article",notes = "Cette methode permet de rechercher et renvoyer la liste des commandes fournisseurs" +
            " d'un article qui existent dans la base des donnees", responseContainer = "List<LigneCommandeFournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des commandes fournisseur / une liste vide")
    })
    List<LigneCommandeFournisseurDto> findHistoryCommandeFournisseur(@PathVariable("id_Article") Integer idArticle);


    @GetMapping(value = Constants.APP_ROOT+"article/filter/categorie/{id_categorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles par categorie",notes = "Cette methode permet de rechercher et renvoyer la liste des articles par categorie" +
            " qui existent dans la base des donnees", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des article / une liste vide")
    })
    List<ArticleDto> findAllArticleByCategory(Integer idCategorie);

    @DeleteMapping(value = Constants.APP_ROOT+"article/{id_article}")
    @ApiOperation(value = "Supprimer un article",notes = "Cette methode permet de supprimer un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete supprimer")
    })
    public void delete(@PathVariable("id_article") Integer idArticle);

}
