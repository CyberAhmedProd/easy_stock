package com.teamyostrik.easystock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="ligne_vente")
public class LigneVente extends AbstractEntity{

g

	@ManyToOne
	@JoinColumn(name ="id_article")
	private Article article;
	@ManyToOne
	@JoinColumn(name = "id_vente")
	private Vente vente;
	@Column(name = "quantite")
	private float quantite;
	
	@Column(name = "prix_unitaire")
	private float prixUnitiare;
}
