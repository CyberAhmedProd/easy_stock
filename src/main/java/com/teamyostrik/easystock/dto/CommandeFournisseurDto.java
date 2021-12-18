package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;

import com.teamyostrik.easystock.models.CommandeFournisseur;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {
	private Integer id;
	private String codeCommande;
	private Instant dateCommande;
	private FournisseurDto fournisseur;
	@Ignore
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
		return commandeFournisseur;
	}
}
