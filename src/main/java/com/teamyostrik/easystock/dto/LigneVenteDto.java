package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.LigneVente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	private Integer id;
	private VenteDto vente;
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
		ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
		return ligneVente;
	}
}
