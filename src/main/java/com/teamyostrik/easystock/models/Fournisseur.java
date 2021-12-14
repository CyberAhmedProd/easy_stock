package com.teamyostrik.easystock.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name ="Fournisseur")
public class Fournisseur extends AbstractEntity{
	@Column(name = "nom_client")
	private String nomClient;
	@Column(name = "prenom_client")
	private String prenomClient;
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
