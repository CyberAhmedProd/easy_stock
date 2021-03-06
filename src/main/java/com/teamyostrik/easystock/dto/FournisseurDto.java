package com.teamyostrik.easystock.dto;

import java.util.List;

import com.teamyostrik.easystock.models.Adresse;
import com.teamyostrik.easystock.models.Client;
import com.teamyostrik.easystock.models.Fournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FournisseurDto {

	private Integer id;
	private String nomClient;
	
	private String prenomClient;
	
	private AdresseDto adresse;
	
	private String photo;

	private String email;
	
	private String numTel;
	
	private List<CommandeFournisseurDto> commandeFournisseurs;

	public static FournisseurDto fromEntity(Fournisseur fournisseur)
	{
		if(fournisseur == null)
		{
			return null;
		}
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.nomClient(fournisseur.getNomFournisseur())
				.prenomClient(fournisseur.getPrenomFournisseur())
				.adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
				.photo(fournisseur.getPhoto())
				// add method from entity to commande client
				//.commandeClients(client.getCommandeClients())
				.email(fournisseur.getEmail())
				.numTel(fournisseur.getNumTel())
				.build();

	}

	public static Fournisseur toEntity(FournisseurDto fournisseurDto)
	{
		if(fournisseurDto == null)
		{
			return null;
		}
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNomFournisseur(fournisseurDto.getNomClient());
		fournisseur.setPrenomFournisseur(fournisseurDto.getPrenomClient());
		fournisseur.setEmail(fournisseurDto.getEmail());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));
		return fournisseur;
	}
}
