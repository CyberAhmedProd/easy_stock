package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer> {

    Optional<Vente> findVenteByCode(String code);
}
