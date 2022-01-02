package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.MouvementSockDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MouvementStockValidator {
    public static List<String> validate(MouvementSockDto mouvementSockDto)
    {
        List<String> errors = new ArrayList<>();
        if(mouvementSockDto == null)
        {
            errors.add("Veuillez renseigner la date du mouvement");
            errors.add("Veuillez renseigner la quantite du mouvement");
            errors.add("Veuillez renseigner l'article");
            errors.add("Veuillez renseigner le type du mouvement");
            return errors;
        }
        if(mouvementSockDto.getDateMouvement() == null)
        {
            errors.add("Veuillez renseigner la date du mouvement");
        }
        if(mouvementSockDto.getQuantite() <= 0)
        {
            errors.add("Veuillez renseigner la quantite du mouvement");
        }
        if(mouvementSockDto.getArticle() == null || mouvementSockDto.getArticle().getId() == null)
        {
            errors.add("Veuillez renseigner l'article");
        }
        if(!StringUtils.hasLength(mouvementSockDto.getTypeMouvement().name()))
        {
            errors.add("Veuillez renseigner le type du mouvement");
        }
        return errors;
    }
}
