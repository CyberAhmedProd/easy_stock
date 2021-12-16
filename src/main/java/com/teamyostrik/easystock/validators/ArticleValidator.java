package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto)
    {
        List<String> errors = new ArrayList<>();

        if(articleDto == null)
        {
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la désignation de l'article");
            errors.add("Veuillez affecter le prix unitaire TTC");
            errors.add("Veuillez affecter le taux de TVA");
            errors.add("Veuillez affecter le prix unitaire TTC");
            errors.add("Veuillez attribuer une categorie");
            return errors;
        }


        if(!StringUtils.hasLength(articleDto.getCodeArticle()))
        {
            errors.add("Veuillez renseigner le code de l'article");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation()))
        {
            errors.add("Veuillez renseigner la désignation de l'article");
        }
        if(articleDto.getPrixUnitaireHT() == 0)
        {
            errors.add("Veuillez affecter un prix unitaire HT");
        }
        if(articleDto.getTauxTVA() == 0)
        {
            errors.add("Veuillez affecter le taux de TVA");
        }
        if(articleDto.getPrixUnitaireTTC() == 0)
        {
            errors.add("Veuillez affecter le prix unitaire TTC");
        }

        if(articleDto.getCategory() == null)
        {
            errors.add("Veuillez attribuer une categorie");
        }

        return errors;
    }
}
