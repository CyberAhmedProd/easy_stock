package com.teamyostrik.easystock.dto;

import com.teamyostrik.easystock.models.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VenteDto {
	private Integer id;
	private String code;
	private Instant dateVente;
	private String commentaire;

	public static VenteDto fromEntity(Vente vente)
	{
		if(vente == null)
		{
			return null;
		}
		return VenteDto.builder()
				.id(vente.getId())
				.code(vente.getCode())
				.dateVente(vente.getDateVente())
				.commentaire(vente.getCommentaire())
				.build();
	}
	public static Vente toEntity(VenteDto venteDto)
	{
		if(venteDto == null)
		{
			return null;
		}
		Vente vente = new Vente();
		vente.setCode(venteDto.getCode());
		vente.setCommentaire(venteDto.getCommentaire());
		// A voir si automatqiue niveau BD --->
		//vente.setDateVente(venteDto.getDateVente());
		return vente;
	}
}
