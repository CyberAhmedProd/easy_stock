package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {

    Categorie save(Categorie categorie);
    Optional<Categorie> findById(Integer id);
    Optional<Categorie> findByCodeCategorie(String CodeCategory);
}
