package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;
import com.teamyostrik.easystock.models.Fournisseur;
import com.teamyostrik.easystock.models.LigneCommandeFournisseur;

public class CommandeFournisseurDto {

	private String codeCommande;
	
	private Instant dateCommande;
	
	private Fournisseur fournisseur;
	
	private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
