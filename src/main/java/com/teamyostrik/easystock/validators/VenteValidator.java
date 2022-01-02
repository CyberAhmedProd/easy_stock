package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VenteDto venteDto)
    {
        List<String> errors = new ArrayList<>();
        if(venteDto == null)
        {
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner la date de la vente");

        }
        if(StringUtils.hasLength(venteDto.getCode()))
        {
            errors.add("Veuillez renseigner le code de la vente");
        }
        if(venteDto.getDateVente() == null)
        {
            errors.add("Veuillez renseigner la date de la vente");
        }


        return errors;
    }
}
