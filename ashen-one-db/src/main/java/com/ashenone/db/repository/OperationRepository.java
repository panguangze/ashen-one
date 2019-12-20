package com.ashenone.db.repository;

import com.ashenone.db.entity.OperationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationRecord, Integer> {
}
