package com.teamyostrik.easystock.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="commande_fournisseur")
public class CommandeFournisseur extends AbstractEntity{

	@Column(name = "code_commande")
	private String codeCommande;
	
	@Column(name = "date_commande" )
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany
	private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
