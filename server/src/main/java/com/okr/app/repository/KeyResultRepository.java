package com.okr.app.repository;

import com.okr.app.model.KeyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyResultRepository extends JpaRepository<KeyResult, Long> {
}
