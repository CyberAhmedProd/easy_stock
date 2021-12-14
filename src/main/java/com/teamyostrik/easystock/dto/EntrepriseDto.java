package com.teamyostrik.easystock.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

	private Integer id;
	private String nom;
	
	private String designation;
	
	private AdresseDto adresse;
	
	private String photo;
	
	private String email;
	
	private String numTel;
	
	private String siteWeb;
	
	private List<UtilisateurDto> utilisateurs;
}
