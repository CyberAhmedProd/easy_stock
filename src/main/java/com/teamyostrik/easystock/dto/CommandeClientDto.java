package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;

import com.teamyostrik.easystock.models.Client;
import com.teamyostrik.easystock.models.LigneCommandeClient;

public class CommandeClientDto {

	private String codeCommandeClient;
	private Instant dateCommande;
	private Client client;
	private List<LigneCommandeClient> ligneCommandeClients;
}
