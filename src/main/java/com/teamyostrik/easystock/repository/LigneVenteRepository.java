package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.CommandeFournisseur;
import com.teamyostrik.easystock.models.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente,Integer> {
    List<LigneVente> findAllByArticleId(Integer idArticle);
    List<LigneVente> findAllByVenteId(Integer idVente);
}
