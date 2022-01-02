package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.AdresseDto;
import com.teamyostrik.easystock.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {
    public static List<String> validate(AdresseDto adresseDto)
    {
        List<String> errors = new ArrayList<>();

        if(adresseDto ==  null)
        {
            errors.add("Veillez renseigner l'adresse 1");
            errors.add("Veillez renseigner la ville");
            errors.add("Veillez renseigner le pays");
            errors.add("Veillez renseigner le code postal");
        }
        if (!StringUtils.hasLength(adresseDto.getAdresse1()))
        {
            errors.add("Veillez renseigner l'adresse 1");
        }
        if (!StringUtils.hasLength(adresseDto.getVille()))
        {
            errors.add("Veillez renseigner la ville");
        }
        if (!StringUtils.hasLength(adresseDto.getPays()))
        {
            errors.add("Veillez renseigner le pays");
        }
        if (!StringUtils.hasLength(adresseDto.getCodePotale()))
        {
            errors.add("Veillez renseigner le code postal");
        }

        return errors;
    }
}
