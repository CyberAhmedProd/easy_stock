package com.teamyostrik.easystock.dto;

import java.util.List;

import com.teamyostrik.easystock.models.Adresse;
import com.teamyostrik.easystock.models.Utilisateur;

public class EntrepriseDto {

	
	private String nom;
	
	private String designation;
	
	private Adresse adresse;
	
	private String photo;
	
	private String email;
	
	private String numTel;
	
	private String siteWeb;
	
	private List<Utilisateur> utilisateurs;
}
