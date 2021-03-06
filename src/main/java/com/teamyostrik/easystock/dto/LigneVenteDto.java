package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.LigneVente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	private Integer id;
	private VenteDto vente;
	private ArticleDto article;
	private float quantite;
	private float prixUnitiare;

	public static LigneVenteDto fromEntity(LigneVente ligneVente)
	{
		if(ligneVente == null)
		{
			return null;
		}
		return LigneVenteDto.builder()
				.id(ligneVente.getId())
				.prixUnitiare(ligneVente.getPrixUnitiare())
				.quantite(ligneVente.getQuantite())
				.article(ArticleDto.fromEnity(ligneVente.getArticle()))
				.vente(VenteDto.fromEntity(ligneVente.getVente()))
				.build();
	}
	public static LigneVente toEntity(LigneVenteDto ligneVenteDto)
	{
		if(ligneVenteDto == null)
		{
			return null;
		}
		LigneVente ligneVente = new LigneVente();
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setQuantite(ligneVenteDto.getQuantite());
		ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
		ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
		return ligneVente;
	}
}
