package com.teamyostrik.easystock.dto;

import java.time.Instant;
import com.teamyostrik.easystock.models.Article;
import com.teamyostrik.easystock.models.TypeMouvement;

public class MouvementSockDto {

	private Article article;
	
	private Instant dateMouvement;
	
	private float quantite;
	 
	private TypeMouvement typeMouvement; 
	
}
