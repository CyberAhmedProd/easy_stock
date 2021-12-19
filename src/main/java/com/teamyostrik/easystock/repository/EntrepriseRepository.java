package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {
}
