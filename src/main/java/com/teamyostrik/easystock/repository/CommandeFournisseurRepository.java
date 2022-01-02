package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.CommandeClient;
import com.teamyostrik.easystock.models.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur,Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurByCodeCommande(String CodeCommande);
    List<CommandeFournisseur> findAllByFournisseurId(Integer idFournisseur);
}
