package com.teamyostrik.easystock.dto;

import java.util.List;
import com.teamyostrik.easystock.models.Adresse;
import com.teamyostrik.easystock.models.CommandeFournisseur;

public class FournisseurDto {
	
	private String nomClient;
	
	private String prenomClient;
	
	private Adresse adresse;
	
	private String photo;

	private String email;
	
	private String numTel;
	
	private List<CommandeFournisseur> commandeFournisseurs;
}
