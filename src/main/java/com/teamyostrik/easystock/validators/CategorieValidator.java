package com.teamyostrik.easystock.validators;

import com.teamyostrik.easystock.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {
    public static List<String> validate(CategorieDto categorieDto)
    {
        List<String> errors = new ArrayList<>();

        if(categorieDto ==  null || !StringUtils.hasLength(categorieDto.getCodeCategorie()))
        {
            errors.add("Veillez renseigner le code de la categorie");
        }

        return errors;
    }
}
