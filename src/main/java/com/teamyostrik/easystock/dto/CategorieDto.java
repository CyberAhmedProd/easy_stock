package com.teamyostrik.easystock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamyostrik.easystock.models.Categorie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDto {

	private Integer id;
	private String codeCategorie;
	private String designation	;
	@JsonIgnore
	private List<ArticleDto> articles;

	//map CategorieDto  ----> Categeorie
	public static CategorieDto fromEntity(Categorie categorie)
	{
		if(categorie == null)
		{
			return null;
			// throw exception .... . . 
			
		}
		return CategorieDto.builder()

				.id(categorie.getId())
				.designation(categorie.getDesignation())
				.codeCategorie(categorie.getCodeCategorie())
				.build();

	}

	public static Categorie toEntity(CategorieDto categorieDto)
	{
		if(categorieDto == null)
		{
			return null;
			// throw exception .... . .

		}
		Categorie categorie = new Categorie();
		categorie.setId(categorieDto.getId());
		categorie.setDesignation(categorieDto.getDesignation());
		categorie.setCodeCategorie(categorieDto.getCodeCategorie());
		return categorie;

	}
}
