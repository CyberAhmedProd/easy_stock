package com.teamyostrik.easystock.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name ="Fournisseur")
public class Fournisseur extends AbstractEntity{
	
	@Column(name = "nom_fournisseur")
	private String nomFournisseur;
	@Column(name = "prenom_fournisseur")
	private String prenomFournisseur;
	@Embedded
	private Adresse adresse;
	@Column(name = "photo")
	private String photo;
	@Column(name = "email")
	private String email;
	@Column(name = "num_tel")
	private String numTel;
	@OneToMany(mappedBy = "fournisseur")
	private List<CommandeFournisseur> commandeFournisseurs;
}
