package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.models.CommandeClient;

public class LigneCommandeClientDto {

	private Article article;

	private CommandeClient commandeClient;
	
	private float quantite;
	
	private float prixUnitiare;
}
