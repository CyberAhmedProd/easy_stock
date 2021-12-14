package com.teamyostrik.easystock.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name ="utilisateur")
public class Utilisateur extends AbstractEntity{

	@Column(name = "nom_utilisateur")
	private String nom;
	@Column(name = "prenom_utilisateur")
	private String prenom;
	@Column(name = "date_naissance")
	private Instant DateNaissance;
	@Column(name = "mot_de_passe")
	private String motDePasse;
	@Embedded
	private Adresse adresse;
	@Column(name ="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "id_entreprise")
	private Entreprise entreprise;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Roles> roles;
	
	
}
