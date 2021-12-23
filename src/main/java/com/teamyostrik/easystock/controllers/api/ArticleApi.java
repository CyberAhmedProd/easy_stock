package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.utils.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(Constants.APP_ROOT + "/articles")
public interface ArticleApi {

    @PostMapping(value = Constants.APP_ROOT+"article/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article",notes = "Cette methode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree / modifie"),
            @ApiResponse(code = 404, message = "L'objet n'est pas valide")
    })
    public ArticleDto save(@RequestBody ArticleDto article);

    @GetMapping(value = Constants.APP_ROOT+"article/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un article par ID",notes = "Cette methode permet rechercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "L'article n'existe pas dans la base des donnees avec l'ID fourni")
    })
    public ArticleDto getArticleById(@PathVariable("id_article") Integer idArticle);

    @GetMapping(value = Constants.APP_ROOT+"article/{code_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un article par Code",notes = "Cette methode permet de rechercher un article par son Code", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article est disponible dans la base des donnees"),
            @ApiResponse(code = 404, message = "L'article n'existe pas dans la base des donnees avec le code fourni")
    })
    public ArticleDto getArticleByCode(@PathVariable("code_article") String codeArticle);

    @GetMapping(value = Constants.APP_ROOT+"article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles",notes = "Cette methode permet de rechercher et renvoyer la liste des articles " +
            "qui existent dans la base des donnees", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des articles / une liste vide")
    })
    public List<ArticleDto> getAll();

    @DeleteMapping(value = Constants.APP_ROOT+"article//delete/{id_article}")
    @ApiOperation(value = "Supprimer un article",notes = "Cette methode permet de supprimer un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete supprimer")
    })
    public void delete(@PathVariable("id_article") Integer idArticle);

}
