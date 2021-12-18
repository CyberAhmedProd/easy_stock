package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.models.Categorie;
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

	public static ArticleDto fromEnity(Article article)
	{
		if(article == null)
		{
			return null;
		}
		return ArticleDto.builder()
				.id(article.getId())
				.codeArticle(article.getCodeArticle())
				.designation(article.getDesignation())
				.prixUnitaireHT(article.getPrixUnitaireHT())
				.tauxTVA(article.getTauxTVA())
				.prixUnitaireTTC(article.getPrixUnitaireTTC())
				.photo(article.getPhoto())
				.category(CategorieDto.fromEntity(article.getCategory()))
				.build();
	}

	public static Article toEntity(ArticleDto articleDto)
	{
		if(articleDto == null)
		{
			return null;
		}
		Article article = new Article();
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPrixUnitaireHT(articleDto.getPrixUnitaireHT());
		article.setTauxTVA(articleDto.getTauxTVA());
		article.setPrixUnitaireTTC(articleDto.getPrixUnitaireTTC());
		article.setPhoto(articleDto.getPhoto());
		article.setCategory(CategorieDto.toEntity(articleDto.getCategory()));
		return article;
	}
	
}
