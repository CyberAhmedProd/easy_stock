package com.teamyostrik.easystock.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.teamyostrik.easystock.models.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {

	private Integer id;
	private String nom;
	private String prenom;
	private Instant DateNaissance;
	private String motDePasse;
	private String email;
	private AdresseDto adresse;
	private String photo;
	private EntrepriseDto entreprise;
	private List<RolesDto> roles;
	public static UtilisateurDto fromEntity(Utilisateur utilisateur)
	{
		if(utilisateur == null)
		{
			return null;
		}
		return UtilisateurDto.builder()
				.id(utilisateur.getId())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.photo(utilisateur.getPhoto())
				.adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
				.DateNaissance(utilisateur.getDateNaissance())
				.email(utilisateur.getEmail())
				.entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
				.roles(
						utilisateur.getRoles() != null ?
								utilisateur.getRoles().stream()
										.map(RolesDto :: fromEntity)
										.collect(Collectors.toList()) : null
				)
				.motDePasse(utilisateur.getMotDePasse())
				.build();
	}

	public static Utilisateur toEntity(UtilisateurDto utilisateurDto)
	{
		if(utilisateurDto == null)
		{
			return null;
		}
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
		utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
		utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
		utilisateur.setRoles(
				utilisateur.getRoles() != null ?
						utilisateurDto.getRoles().stream()
								.map(RolesDto :: toEntity)
								.collect(Collectors.toList()) : null
		);



		return utilisateur;
	}
}
