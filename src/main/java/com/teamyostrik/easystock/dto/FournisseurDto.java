package com.teamyostrik.easystock.dto;

import java.util.List;
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
}
