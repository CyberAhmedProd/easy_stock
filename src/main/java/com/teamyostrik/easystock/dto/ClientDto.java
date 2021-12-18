package com.teamyostrik.easystock.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamyostrik.easystock.models.Adresse;
import com.teamyostrik.easystock.models.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	private Integer id;
	private String nomClient;
	private String prenomClient;
	private AdresseDto adresse;
	private String photo;
	private String email;
	private String numTel;
	@JsonIgnore
	private List<CommandeClientDto> commandeClients;

	public static ClientDto fromEntity(Client client)
	{
		if(client == null)
		{
			return null;
		}
		return ClientDto.builder()
				.id(client.getId())
				.nomClient(client.getNomClient())
				.prenomClient(client.getPrenomClient())
				.adresse(AdresseDto.fromEntity(client.getAdresse()))
				.photo(client.getPhoto())
				// add method from entity to commande client
				//.commandeClients(client.getCommandeClients())
				.email(client.getEmail())
				.numTel(client.getNumTel())
				.build();
	}
	public static Client toEntity(ClientDto clientDto)
	{
		if(clientDto == null)
		{
			return null;
		}
		Client client = new Client();
		client.setNomClient(clientDto.getNomClient());
		client.setPrenomClient(clientDto.getPrenomClient());
		client.setEmail(clientDto.getEmail());
		client.setNumTel(clientDto.getNumTel());
		client.setPhoto(clientDto.getPhoto());
		client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
		return client;
	}
}
