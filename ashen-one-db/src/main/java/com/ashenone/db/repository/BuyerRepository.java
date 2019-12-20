package com.ashenone.db.repository;

import com.ashenone.db.entity.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<BuyerEntity, Integer> {
}
