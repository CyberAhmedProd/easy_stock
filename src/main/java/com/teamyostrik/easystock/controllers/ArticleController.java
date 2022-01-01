package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.ArticleApi;
import com.teamyostrik.easystock.dto.*;
import com.teamyostrik.easystock.models.Categorie;
import com.teamyostrik.easystock.repository.CategorieRepository;
import com.teamyostrik.easystock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public ResponseEntity<ArticleDto> save(ArticleDto article) {
        return ResponseEntity.ok(articleService.save(article));
    }

    @Override
    public ResponseEntity<ArticleDto> getArticleById(Integer idArticle) {

        return ResponseEntity.ok(articleService.findById(idArticle));
    }

    @Override
    public ResponseEntity<ArticleDto> getArticleByCode(String codeArticle) {
        return ResponseEntity.ok(articleService.findByCodeArticle(codeArticle));
    }

    @Override
    public ResponseEntity<List<ArticleDto>> getAll() {

        return ResponseEntity.ok(articleService.findAll());
    }

    @Override
    public List<LigneVenteDto> findHistoryVentes(Integer idArticle) {
        return articleService.findHistoryVentes(idArticle);
    }

    @Override
    public List<LigneCommandeClientDto> findHistoryCommandeCLient(Integer idArticle) {
        return articleService.findHistoryCommandeCLient(idArticle);
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoryCommandeFournisseur(Integer idArticle) {
        return articleService.findHistoryCommandeFournisseur(idArticle);
    }

    @Override
    public List<ArticleDto> findAllArticleByCategory(Integer idCategorie) {
        return articleService.findAllArticleByCategory(idCategorie);
    }

    @Override
    public void delete(Integer idArticle) {

        articleService.delete(idArticle);
    }
}
