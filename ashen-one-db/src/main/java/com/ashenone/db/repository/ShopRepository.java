package com.ashenone.db.repository;

import com.ashenone.db.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {
}
