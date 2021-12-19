package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Integer, Categorie> {
}
