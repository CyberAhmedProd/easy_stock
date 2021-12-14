package com.teamyostrik.easystock.dto;

import java.util.List;
import com.teamyostrik.easystock.models.Adresse;
import com.teamyostrik.easystock.models.CommandeClient;

public class ClientDto {


	
	private String nomClient;

	private String prenomClient;

	private Adresse adresse;

	private String photo;

	private String email;

	private String numTel;
	
	private List<CommandeClient> commandeClients;
}
