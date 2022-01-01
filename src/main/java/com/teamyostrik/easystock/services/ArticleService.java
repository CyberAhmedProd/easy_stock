package com.teamyostrik.easystock.services;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.dto.LigneCommandeClientDto;
import com.teamyostrik.easystock.dto.LigneCommandeFournisseurDto;
import com.teamyostrik.easystock.dto.LigneVenteDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByCodeArticle(String codeArticle);
    List<ArticleDto> findAll();
    List<LigneVenteDto> findHistoryVentes(Integer idArticle);
    List<LigneCommandeClientDto> findHistoryCommandeCLient(Integer idArticle);
    List<LigneCommandeFournisseurDto> findHistoryCommandeFournisseur(Integer idArticle);
    List<ArticleDto> findAllArticleByCategory(Integer idCategorie);
    void delete(Integer id);
}
