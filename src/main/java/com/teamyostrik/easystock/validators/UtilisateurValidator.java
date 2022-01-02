package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto)
    {
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null)
        {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prénom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom()))
        {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getPrenom()))
        {
            errors.add("Veuillez renseigner le prénom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail()))
        {
            errors.add("Veuillez renseigner un mot de pass d'utilisateur");
        }
        if(utilisateurDto.getDateNaissance() == null)
        {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        errors.addAll(AdresseValidator.validate(utilisateurDto.getAdresse()));
        return  errors;
    }
}
