package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {

    List<LigneCommandeFournisseur> findAllByCommandeFournisseursId(Integer idCommande);
    List<LigneCommandeFournisseur> findAllByArticleId(Integer idCommande);
}
