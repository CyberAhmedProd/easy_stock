package com.teamyostrik.easystock.controllers;


import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.teamyostrik.easystock.utils.Constants;
import java.util.List;
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping(value = Constants.APP_ROOT+"article/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto save(Article article)
    {
        
        Article testArticle1 = new Article();
        testArticle1.setId(12);
        testArticle1.setCodeArticle("55ARTt");
        testArticle1.setDesignation("Hello");
        return ArticleDto.fromEnity(testArticle1);
    }
    @GetMapping(value = Constants.APP_ROOT+"article/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto getArticle()
    {
        return null;
    }
    @GetMapping(value = Constants.APP_ROOT+"article", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> getAll()
    {
        return null;
    }
    @PutMapping(value = Constants.APP_ROOT+"article/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto update(@RequestParam Integer id , ArticleDto articleDto) {return null;}
    @DeleteMapping(value = Constants.APP_ROOT+"article/{id}")
    public void delete(@RequestParam Integer id) {}

}
