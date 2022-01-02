package com.teamyostrik.easystock.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamyostrik.easystock.models.Entreprise;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

	private Integer id;
	private String nom;
	private String codeFiscale;
	private String designation;
	
	private AdresseDto adresse;
	
	private String photo;
	
	private String email;
	
	private String numTel;
	
	private String siteWeb;

	@JsonIgnore
	private List<UtilisateurDto> utilisateurs;

	public static EntrepriseDto fromEntity(Entreprise entreprise)
	{
		if(entreprise == null)
		{
			return null;
		}
		return EntrepriseDto.builder()
				.id(entreprise.getId())
				.nom(entreprise.getNom())
				.designation(entreprise.getDesignation())
				.adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
				.codeFiscale(entreprise.getCodeFiscale())
				.email(entreprise.getEmail())
				.numTel(entreprise.getNumTel())
				.siteWeb(entreprise.getSiteWeb())
				.photo(entreprise.getPhoto())
				.build();
	}

	public static Entreprise toEntity(EntrepriseDto entrepriseDto)
	{
		if(entrepriseDto == null)
		{
			return null;
		}
		Entreprise entreprise = new Entreprise();
		entreprise.setNom(entrepriseDto.getNom());
		entreprise.setDesignation(entrepriseDto.getDesignation());
		entreprise.setPhoto(entrepriseDto.getPhoto());
		entreprise.setNumTel(entrepriseDto.getNumTel());
		entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
		entreprise.setEmail(entrepriseDto.getEmail());
		entreprise.setCodeFiscale(entrepriseDto.getCodeFiscale());
		entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
		return entreprise;

	}
}
