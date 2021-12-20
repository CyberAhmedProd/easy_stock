package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeClientRepository extends JpaRepository<CommandeClient,Integer> {

    Optional<CommandeClient> findCommandeClientByCodeCommandeClient(String codeCommandeClient);
}
