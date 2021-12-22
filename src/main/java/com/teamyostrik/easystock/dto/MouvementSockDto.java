package com.teamyostrik.easystock.dto;

import java.time.Instant;
import com.teamyostrik.easystock.models.MouvementSock;
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

	public static MouvementSockDto fromEntity(MouvementSock mouvementSock)
	{
		if(mouvementSock == null)
		{
			return null;
		}

		return MouvementSockDto.builder()
				.id(mouvementSock.getId())
				.dateMouvement(mouvementSock.getDateMouvement())
				.typeMouvement(mouvementSock.getTypeMouvement())
				.article(ArticleDto.fromEnity(mouvementSock.getArticle()))
				.quantite(mouvementSock.getQuantite())
				.build();
	}
	public static MouvementSock toEntity(MouvementSockDto mouvementSockDto)
	{
		if(mouvementSockDto == null)
		{
			return null;
		}
		MouvementSock mouvementSock = new MouvementSock();
		mouvementSock.setQuantite(mouvementSockDto.getQuantite());
		mouvementSock.setTypeMouvement(mouvementSockDto.getTypeMouvement());
		mouvementSock.setArticle(ArticleDto.toEntity(mouvementSockDto.getArticle()));
		mouvementSock.setDateMouvement(mouvementSockDto.getDateMouvement());
		return mouvementSock;
	}
	
}
