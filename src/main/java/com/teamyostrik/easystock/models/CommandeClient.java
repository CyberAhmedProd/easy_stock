package com.teamyostrik.easystock.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name ="commande_client")
public class CommandeClient extends AbstractEntity{

	@Column(name="code_commande_client")
	private String codeCommandeClient;
	
	@Column(name ="date_commande")
	private Instant dateCommande;

	@Column(name = "etat_commande")
	private EtatCommande etatCommande;

	@Column(name = "id_entreprise")
	private Integer idEntreprise;
	@ManyToOne
	@JoinColumn(name ="id_client")
	private Client client;
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;
}
