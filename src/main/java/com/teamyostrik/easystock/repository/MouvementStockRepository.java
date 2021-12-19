package com.teamyostrik.easystock.repository;

import com.teamyostrik.easystock.models.MouvementSock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementStockRepository extends JpaRepository<Integer, MouvementSock> {
}
