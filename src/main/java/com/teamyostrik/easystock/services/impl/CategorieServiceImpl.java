package com.teamyostrik.easystock.services.impl;

import com.teamyostrik.easystock.dto.ArticleDto;
import com.teamyostrik.easystock.dto.CategorieDto;
import com.teamyostrik.easystock.exceptions.EntityNotFoundExceptions;
import com.teamyostrik.easystock.exceptions.ErrorCode;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.models.Categorie;
import com.teamyostrik.easystock.repository.CategorieRepository;
import com.teamyostrik.easystock.services.CategorieService;
import com.teamyostrik.easystock.validators.ArticleValidator;
import com.teamyostrik.easystock.validators.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Override
    public CategorieDto save(CategorieDto categorieDto) {
        List<String> errors = CategorieValidator.validate(categorieDto);
        if(!errors.isEmpty())
        {
            log.error("Categorie is not valid {}", categorieDto);
            throw new EntityNotFoundExceptions("la catgorie n'est pas valide" ,  ErrorCode.CATEGORY_NOT_FOUND );
        }
        return categorieDto.fromEntity(
                categorieRepository.save(CategorieDto.toEntity(categorieDto))
        );
    }

    @Override
    public CategorieDto findById(Integer id) {
        if(id == null)
        {
            log.error("Article id is null");
            return null;
        }
        Optional<Categorie> categorie = categorieRepository.findCategorieById(id);
        return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucune categorie avec l'id= "+ id
                        + " n'est été trouver dans la bd",
                        ErrorCode.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategorieDto findByCodeArticle(String codeCategorie) {
        if(!StringUtils.hasLength(codeCategorie))
        {
            log.error("Article Code is null");
            return null;
        }
        Optional<Categorie> categorie = categorieRepository.findCategorieByCodeCategory(codeCategorie);
        return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() ->
                new EntityNotFoundExceptions("Aucune categorie avec le code= "+ codeCategorie
                        + " n'est été trouver dans la bd",
                        ErrorCode.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategorieDto> findAll() {
        return  categorieRepository.findAll().stream()
                .map(CategorieDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null)
        {
            log.error("Article ID is null");
            return;
        }
        categorieRepository.deleteById(id);
    }
}
