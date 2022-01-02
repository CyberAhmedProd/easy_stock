package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.FournisseurDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto)
    {
        List<String> errors = new ArrayList<>();

        if(fournisseurDto == null)
        {
            errors.add("Veuillez saisir un nom du fournisseur");
            errors.add("Veuillez saisir un prénom du fournisseur");
            errors.add("Veuillez saisir un email du fournisseur");
            errors.add("Veuillez saisir le numéro du téléphone du fournisseur");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }
        if(!StringUtils.hasLength(fournisseurDto.getNomClient()))
        {
            errors.add("Veuillez saisir un nom du fournisseur");
        }
        if(!StringUtils.hasLength(fournisseurDto.getPrenomClient()))
        {
            errors.add("Veuillez saisir un prénom du fournisseur");
        }
        if(!StringUtils.hasLength(fournisseurDto.getEmail()))
        {
            errors.add("Veuillez saisir un email du fournisseur");
        }
        if(!StringUtils.hasLength(fournisseurDto.getNumTel()))
        {
            errors.add("Veuillez saisir le numéro du téléphone du fournisseur");
        }
        if(!StringUtils.hasLength(fournisseurDto.getNomClient()))
        {
            errors.add("Veuillez saisir un nom du fournisseur");
        }
        errors.addAll(AdresseValidator.validate(fournisseurDto.getAdresse()));
        return errors;
    }
}
