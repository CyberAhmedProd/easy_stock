package com.teamyostrik.easystock.models;

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
@Table(name ="ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name ="id_article")
	private Article article;
	@ManyToOne
	@JoinColumn(name = "id_commande_fournisseur")
	private CommandeFournisseur commandeFournisseurs;
}
