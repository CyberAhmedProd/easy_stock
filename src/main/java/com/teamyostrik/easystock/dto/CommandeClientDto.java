package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {
	private Integer id;
	private String codeCommandeClient;
	private Instant dateCommande;
	private ClientDto client;
	private List<LigneCommandeClientDto> ligneCommandeClients;
}
