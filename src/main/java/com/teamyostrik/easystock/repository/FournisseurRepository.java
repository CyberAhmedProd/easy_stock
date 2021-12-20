package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {

    Optional<Fournisseur> findById(Integer id);



}
