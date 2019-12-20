package com.ashenone.db.repository;

import com.ashenone.db.entity.IdentifierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentifierRepository extends JpaRepository<IdentifierEntity, Integer> {
}
