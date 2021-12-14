package com.teamyostrik.easystock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
	private Integer id;
	private ArticleDto article;

	private CommandeFournisseurDto commandeFournisseurs;
	
	private float quantite;
	
	private float prixUnitiare;

}
