package com.teamyostrik.easystock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {
	private Integer id;
	private ArticleDto article;

	private CommandeClientDto commandeClient;
	
	private float quantite;
	
	private float prixUnitiare;
}
