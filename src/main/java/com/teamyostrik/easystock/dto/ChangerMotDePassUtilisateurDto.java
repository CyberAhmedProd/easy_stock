package com.teamyostrik.easystock.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePassUtilisateurDto {

    private Integer id;
    private String motDePass;
    private String confirmMotDePasse;
}
