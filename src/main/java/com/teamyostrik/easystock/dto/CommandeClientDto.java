package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamyostrik.easystock.models.Client;
import com.teamyostrik.easystock.models.CommandeClient;
import com.teamyostrik.easystock.models.EtatCommande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeClientDto {

	private Integer id;
	private String codeCommandeClient;
	private Instant dateCommande;
	private ClientDto client;
	private Integer idEntreprise;
	private EtatCommande etatCommande;
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
				.etatCommande(commandeClient.getEtatCommande())
				.client(ClientDto.fromEntity(commandeClient.getClient()))
				.idEntreprise(commandeClient.getIdEntreprise())
				.build();
	}
	public static CommandeClient toEntity(CommandeClientDto commandeClientDto)
	{
		if(commandeClientDto == null)
		{
			return null;
		}
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setId(commandeClientDto.getId());
		commandeClient.setCodeCommandeClient(commandeClientDto.getCodeCommandeClient());
		commandeClient.setDateCommande(commandeClientDto.getDateCommande());
		commandeClient.setEtatCommande(commandeClient.getEtatCommande());
		commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
		commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
		return commandeClient;
	}

	public boolean isCommandeLivree()
	{
		return EtatCommande.LIVREE.equals(this.etatCommande);
	}

}
