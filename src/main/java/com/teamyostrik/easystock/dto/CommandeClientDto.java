package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamyostrik.easystock.models.Client;
import com.teamyostrik.easystock.models.CommandeClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {

	private Integer id;
	private String codeCommandeClient;
	private Instant dateCommande;
	private ClientDto client;
	@JsonIgnore
	private List<LigneCommandeClientDto> ligneCommandeClients;

	public static CommandeClientDto fromEntity(CommandeClient commandeClient)
	{
		if(commandeClient == null )
		{
			return null;
		}
		return CommandeClientDto.builder()
				.id(commandeClient.getId())
				.codeCommandeClient(commandeClient.getCodeCommandeClient())
				.dateCommande(commandeClient.getDateCommande())
				.client(ClientDto.fromEntity(commandeClient.getClient()))
				.build();
	}
	public static CommandeClient toEntity(CommandeClientDto commandeClientDto)
	{
		if(commandeClientDto == null)
		{
			return null;
		}
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setCodeCommandeClient(commandeClientDto.getCodeCommandeClient());
		commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
		commandeClient.setDateCommande(commandeClientDto.getDateCommande());
		return commandeClient;
	}

}
