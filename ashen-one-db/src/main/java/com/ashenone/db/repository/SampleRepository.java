package com.ashenone.db.repository;

import com.ashenone.db.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {
}
