package com.teamyostrik.easystock.dto;

import java.time.Instant;

import com.teamyostrik.easystock.models.TypeMouvement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MouvementSockDto {
	private Integer id;
	private ArticleDto article;
	
	private Instant dateMouvement;
	
	private float quantite;
	 
	private TypeMouvement typeMouvement; 
	
}
