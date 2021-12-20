package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.EntrepriseDto;
import com.teamyostrik.easystock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto)
    {
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null)
        {
            errors.add("Veuillez saisir un nom de l'entreprise");
            errors.add("Veuillez saisir un email du fournisseur");
            errors.add("Veuillez saisir le numéro du téléphone du fournisseur");
            return errors;
        }
        if(!StringUtils.hasLength(entrepriseDto.getNom()))
        {
            errors.add("Veuillez saisir un nom de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getEmail()))
        {
            errors.add("Veuillez saisir un email de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getNumTel()))
        {
            errors.add("Veuillez saisir le numéro du téléphone de l'entreprise");
        }
        return errors;
    }
}
