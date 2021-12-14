package com.teamyostrik.easystock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
	
	private Integer id;

	private String codeArticle;
	
	private String designation	;

	private float prixUnitaireHT;
	
	private float tauxTVA;
	
	private float prixUnitaireTTC;
	
	private String photo;
	
	private CategorieDto category;
	
	
}
