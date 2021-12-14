package com.teamyostrik.easystock.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name ="mouvement_sock")
public class MouvementSock extends AbstractEntity{
	
	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;
	
	@Column(name = "date_mouvement")
	private Instant dateMouvement;
	
	@Column(name = "quantite")
	private float quantite;
	 
	@Column(name ="type_mouvement")
	private TypeMouvement typeMouvement; 
	
	
}
