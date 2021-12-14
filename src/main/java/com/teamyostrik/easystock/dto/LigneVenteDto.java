package com.teamyostrik.easystock.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneVenteDto {
	private Integer id;
	private VenteDto vente;

	private float quantite;
	
	private float prixUnitiare;
}