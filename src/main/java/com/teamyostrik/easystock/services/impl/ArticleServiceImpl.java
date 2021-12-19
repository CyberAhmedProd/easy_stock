package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalidEntityExceptions;
import com.teamyostrik.easystock.handlers.ErrorDto;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.services.ArticleService;
import com.teamyostrik.easystock.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service("ArticleServiceImpl")
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty())
        {
            log.error("Article is not valid {}", articleDto);
            throw new EntityNotFoundExceptions("L'article n'est pas valide" , (Throwable) errors, ErrorCode.ARTICLE_NOT_VALID );
        }

        return articleDto.fromEnity(
                articleRepository.save(ArticleDto.toEntity(articleDto))
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null)
        {
            log.error("Article id is null");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleById(id);
        return Optional.of(ArticleDto.fromEnity(article.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun article avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
       if(!StringUtils.hasLength(codeArticle))
       {
            log.error("Article Code is null");
            return null;
       }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        return Optional.of(ArticleDto.fromEnity(article.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucun article avec l'id= "+ codeArticle
                        + " n'est été trouver dans la bd",
                        ErrorCode.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return  articleRepository.findAll().stream()
                .map(ArticleDto::fromEnity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

    }
}
