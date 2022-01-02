package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto)
    {
        List<String> errors = new ArrayList<>();

        if(clientDto == null)
        {
            errors.add("Veuillez saisir un nom du client");
            errors.add("Veuillez saisir un prénom du client");
            errors.add("Veuillez saisir un email du client");
            errors.add("Veuillez saisir le numéro du téléphone du client");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }
        if(!StringUtils.hasLength(clientDto.getNomClient()))
        {
            errors.add("Veuillez saisir un nom du client");
        }
        if(!StringUtils.hasLength(clientDto.getPrenomClient()))
        {
            errors.add("Veuillez saisir un prénom du client");
        }
        if(!StringUtils.hasLength(clientDto.getEmail()))
        {
            errors.add("Veuillez saisir un email du client");
        }
        if(!StringUtils.hasLength(clientDto.getNumTel()))
        {
            errors.add("Veuillez saisir le numéro du téléphone du client");
        }
        if(!StringUtils.hasLength(clientDto.getNomClient()))
        {
            errors.add("Veuillez saisir un nom du client");
        }

        errors.addAll(AdresseValidator.validate(clientDto.getAdresse()));
        return errors;
    }
}
