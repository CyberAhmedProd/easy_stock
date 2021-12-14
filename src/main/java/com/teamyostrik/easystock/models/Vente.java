package com.teamyostrik.easystock.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)	
@Entity
@Table(name ="vente")
public class Vente extends AbstractEntity{

	@Column(name = "code_vente")
	private String code;
	
	@Column(name = "date_vente")
	private Instant dateVente;
	
	@Column(name = "commentaire")
	private String commentaire;
}
