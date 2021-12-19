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

    @PostMapping(value = Constants.APP_ROOT+"/article/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto save(Article article)
    {
        return null;
    }
    @GetMapping(value = Constants.APP_ROOT+"/article",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> getAll()
    {
        return null;
    }
    @PutMapping(value = Constants.APP_ROOT+"/article/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto update(){
        return null;
    }
    @DeleteMapping(value = Constants.APP_ROOT+"/article/{id}")
    public void delete(@RequestParam Integer id)
    {

    }


}