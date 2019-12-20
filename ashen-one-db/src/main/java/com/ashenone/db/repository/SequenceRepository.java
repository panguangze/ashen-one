package com.ashenone.db.repository;

import com.ashenone.db.entity.SequenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<SequenceEntity, Integer> {
}
