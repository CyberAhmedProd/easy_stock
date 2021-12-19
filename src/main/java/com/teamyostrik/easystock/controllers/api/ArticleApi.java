package com.teamyostrik.easystock.controllers.api;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.utils.Constants;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ArticleApi {

    @PostMapping(value = Constants.APP_ROOT+"article/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto save(@RequestBody ArticleDto article);
    @GetMapping(value = Constants.APP_ROOT+"article/{id_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto getArticleById(@PathVariable("id_article") Integer idArticle);
    @GetMapping(value = Constants.APP_ROOT+"article/{code_article}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto getArticleByCode(@PathVariable("code_article") String codeArticle);
    @GetMapping(value = Constants.APP_ROOT+"article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> getAll();
    @PutMapping(value = Constants.APP_ROOT+"article/{id_article}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto update(@PathVariable("id_article") Integer idArticle, @RequestBody ArticleDto article);
    @DeleteMapping(value = Constants.APP_ROOT+"article//delete/{id_article}")
    public void delete(@PathVariable("id_article") Integer idArticle);

}
