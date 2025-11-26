package com.okr.app.repository;

import com.okr.app.model.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ObjectiveRepository extends JpaRepository<Objective, Long> {
    List<Objective> findByOwnerId(Long ownerId);
}
