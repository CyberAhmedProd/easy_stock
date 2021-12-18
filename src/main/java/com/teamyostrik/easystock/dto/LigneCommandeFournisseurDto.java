package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.LigneCommandeFournisseur;
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
	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur)
	{
		if (ligneCommandeFournisseur == null)
		{
			return null;
		}
		return LigneCommandeFournisseurDto.builder()
				.id(ligneCommandeFournisseur.getId())
				.article(ArticleDto.fromEnity(ligneCommandeFournisseur.getArticle()))
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitiare(ligneCommandeFournisseur.getPrixUnitiare())
				.commandeFournisseurs(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseurs()))
				.build();
	}

	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto)
	{
		if(ligneCommandeFournisseurDto == null)
		{
			return null;
		}
		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setPrixUnitiare(ligneCommandeFournisseurDto.getPrixUnitiare());
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		ligneCommandeFournisseur.setCommandeFournisseurs(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseurs()));
		return ligneCommandeFournisseur;
	}


}
