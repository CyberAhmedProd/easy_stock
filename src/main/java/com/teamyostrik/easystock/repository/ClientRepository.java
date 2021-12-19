package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
