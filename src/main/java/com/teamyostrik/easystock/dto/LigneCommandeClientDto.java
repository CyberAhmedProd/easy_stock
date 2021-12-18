package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.LigneCommandeClient;
import com.teamyostrik.easystock.models.LigneCommandeFournisseur;
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

	public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient)
	{
		if (ligneCommandeClient == null)
		{
			return null;
		}
		return LigneCommandeClientDto.builder()
				.id(ligneCommandeClient.getId())
				.article(ArticleDto.fromEnity(ligneCommandeClient.getArticle()))
				.quantite(ligneCommandeClient.getQuantite())
				.prixUnitiare(ligneCommandeClient.getPrixUnitiare())
				.commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
				.build();
	}

	public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto)
	{
		if(ligneCommandeClientDto == null)
		{
			return null;
		}
		LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
		ligneCommandeClient.setPrixUnitiare(ligneCommandeClientDto.getPrixUnitiare());
		ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
		ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
		ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));
		return ligneCommandeClient;
	}
}
