package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Fournisseur;
import com.teamyostrik.easystock.models.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {
}
