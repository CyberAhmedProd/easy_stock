package com.teamyostrik.easystock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name ="article")
public class Article extends AbstractEntity{
	
	
	@Column(name = "code_article")
	private String codeArticle;
	@Column(name = "designation")
	private String designation	;
	@Column(name = "prix_unitaire_ht")
	private float prixUnitaireHT;
	@Column(name = "taux_tva")
	private float tauxTVA;
	@Column(name = "prix_unitaire_ttc")
	private float prixUnitaireTTC;
	@Column(name ="photo")
	private String photo;
	
}
