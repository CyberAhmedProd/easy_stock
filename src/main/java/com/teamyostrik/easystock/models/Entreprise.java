package com.teamyostrik.easystock.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
@Table(name ="entreprise")
public class Entreprise extends AbstractEntity{
	
	@Column(name = "nom_entreprise")
	private String nom;
	@Column(name = "designation_entreprise")
	private String designation;
	@Embedded
	private Adresse adresse;
	@Column(name ="photo")
	private String photo;
	@Column(name ="email")
	private String email;
	@Column(name = "num_tel")
	private String numTel;
	@Column(name= "site_web")
	private String siteWeb;
	@OneToMany(mappedBy = "entreprise")
	private List<Utilisateur> utilisateurs;
}
