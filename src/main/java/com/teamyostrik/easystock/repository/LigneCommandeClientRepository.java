package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {

    List<LigneCommandeClient> findAllByCommandeClientId(Integer id);
    List<LigneCommandeClient> findAllByArticleId(Integer idCommande);
}
