package com.teamyostrik.easystock.controllers;

import com.teamyostrik.easystock.controllers.api.ArticleApi;
import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.models.Categorie;
import com.teamyostrik.easystock.repository.CategorieRepository;
import com.teamyostrik.easystock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ArticleDto save(ArticleDto article) {
        Categorie categorie = new Categorie();
        categorie.setCodeCategorie("cat14");
        categorie.setDesignation("cat");
        categorie.setCreationDate(Instant.now());
        categorie.setLastUpdateDate(Instant.now());
        article.setCreationDate(Instant.now());
        article.setCategory(CategorieDto.fromEntity(categorieRepository.save(categorie)));
        return articleService.save(article);
    }

    @Override
    public ArticleDto getArticleById(Integer idArticle) {
        return articleService.findById(idArticle);
    }

    @Override
    public ArticleDto getArticleByCode(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> getAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer idArticle) {
        articleService.delete(idArticle);
    }
}
