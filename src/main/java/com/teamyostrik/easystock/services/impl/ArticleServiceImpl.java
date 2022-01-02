package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.dto.LigneCommandeClientDto;
import com.teamyostrik.easystock.dto.LigneCommandeFournisseurDto;
import com.teamyostrik.easystock.dto.LigneVenteDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.exceptions.InvalideOperationException;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.models.LigneCommandeClient;
import com.teamyostrik.easystock.models.LigneCommandeFournisseur;
import com.teamyostrik.easystock.models.LigneVente;
import com.teamyostrik.easystock.repository.ArticleRepository;
import com.teamyostrik.easystock.repository.LigneCommandeClientRepository;
import com.teamyostrik.easystock.repository.LigneCommandeFournisseurRepository;
import com.teamyostrik.easystock.repository.LigneVenteRepository;
import com.teamyostrik.easystock.services.ArticleService;
import com.teamyostrik.easystock.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private LigneVenteRepository ligneVenteRepository;
    @Autowired
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    @Autowired
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty())
        {
            log.error("Article is not valid {}", articleDto);
            throw new EntityNotFoundExceptions("L'article n'est pas valide" ,  ErrorCode.ARTICLE_NOT_VALID );
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
    public List<LigneVenteDto> findHistoryVentes(Integer idArticle) {
        return ligneVenteRepository.findAllByArticleId(idArticle).stream()
                .map(LigneVenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeClientDto> findHistoryCommandeCLient(Integer idArticle) {
        return ligneCommandeClientRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoryCommandeFournisseur(Integer idArticle) {
        return ligneCommandeFournisseurRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticleByCategory(Integer idCategorie) {
        return articleRepository.findAllByCategoryId(idCategorie).stream()
                .map(ArticleDto::fromEnity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Article ID is null");
            return;
        }
        List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByArticleId(id);
        if(!ligneCommandeClients.isEmpty())
        {
            throw new InvalideOperationException
                    (
                            "impossible de supprimer un article deja utilisé dans les commandes clients",
                            ErrorCode.ARTICLE_ALRAEDY_IN_USE
                    );
        }
        List<LigneCommandeFournisseur> ligneCommandeFournisseurs = ligneCommandeFournisseurRepository.findAllByArticleId(id);
        if(!ligneCommandeFournisseurs.isEmpty())
        {
            throw new InvalideOperationException
                    (
                            "impossible de supprimer un article deja utilisé dans les commandes fournisseurs",
                            ErrorCode.ARTICLE_ALRAEDY_IN_USE
                    );
        }
        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByArticleId(id);
        if(!ligneCommandeFournisseurs.isEmpty())
        {
            throw new InvalideOperationException
                    (
                            "impossible de supprimer un article deja utilisé dans les ventes",
                            ErrorCode.ARTICLE_ALRAEDY_IN_USE
                    );
        }
        articleRepository.deleteById(id);
    }
}
