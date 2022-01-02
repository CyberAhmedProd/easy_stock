package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamyostrik.easystock.models.CommandeFournisseur;

import com.teamyostrik.easystock.models.EtatCommande;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {
	private Integer id;
	private String codeCommande;
	private Instant dateCommande;
	private EtatCommande etatCommande;
	private Integer idEntreprise;
	private FournisseurDto fournisseur;
	@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur)
	{
		if(commandeFournisseur == null)
		{
			return null;
		}
		return CommandeFournisseurDto.builder()
				.id(commandeFournisseur.getId())
				.codeCommande(commandeFournisseur.getCodeCommande())
				.dateCommande(commandeFournisseur.getDateCommande())
				.idEntreprise(commandeFournisseur.getIdEntreprise())
				.etatCommande(commandeFournisseur.getEtatCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
				.build();
	}

	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto)
	{
		if(commandeFournisseurDto == null)
		{
			return null;
		}
		CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
		commandeFournisseur.setCodeCommande(commandeFournisseurDto.getCodeCommande());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
		commandeFournisseur.setEtatCommande(commandeFournisseurDto.getEtatCommande());
		return commandeFournisseur;
	}
}
