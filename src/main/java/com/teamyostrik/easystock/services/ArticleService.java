package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    void delete(Integer id);
}
