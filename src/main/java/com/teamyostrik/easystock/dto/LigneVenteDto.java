package com.teamyostrik.easystock.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.teamyostrik.easystock.models.Vente;

public class LigneVenteDto {

	private Vente vente;

	private float quantite;
	
	private float prixUnitiare;
}
