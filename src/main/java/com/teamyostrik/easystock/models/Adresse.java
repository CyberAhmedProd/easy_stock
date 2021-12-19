package com.teamyostrik.easystock.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class Adresse implements Serializable{
	
	@Column(name = "adresse1")
	private String adresse1;
	@Column(name = "adresse2")
	private String adresse2;
	@Column(name = "ville")
	private String ville;
	@Column(name = "code_potale")
	private String codePotale;
	@Column(name = "pays")
	private String pays;

}
