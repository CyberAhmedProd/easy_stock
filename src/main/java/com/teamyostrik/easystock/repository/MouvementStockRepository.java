package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.MouvementSock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementSock,Integer> {

    @Query("select sum(m.quantite) from MouvementSock m where m.article.id = :idArticle")
    BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

    List<MouvementSock> findAllByArticleId(Integer idArticle);
}
