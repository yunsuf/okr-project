package com.okr.app.service;

import com.okr.app.model.KeyResult;
import com.okr.app.model.Objective;
import com.okr.app.model.User;
import com.okr.app.repository.KeyResultRepository;
import com.okr.app.repository.ObjectiveRepository;
import com.okr.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OkrService {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private KeyResultRepository keyResultRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Objective> getAllObjectives() {
        return objectiveRepository.findAll();
    }

    public List<Objective> getObjectivesByUserId(Long userId) {
        return objectiveRepository.findByOwnerId(userId);
    }

    public Objective createObjective(Objective objective, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        objective.setOwner(user);
        return objectiveRepository.save(objective);
    }

    public Objective updateObjective(Long id, Objective objectiveDetails) {
        Objective objective = objectiveRepository.findById(id).orElseThrow(() -> new RuntimeException("Objective not found"));
        objective.setTitle(objectiveDetails.getTitle());
        objective.setDescription(objectiveDetails.getDescription());
        objective.setStatus(objectiveDetails.getStatus());
        return objectiveRepository.save(objective);
    }

    public void deleteObjective(Long id) {
        objectiveRepository.deleteById(id);
    }

    public KeyResult addKeyResult(Long objectiveId, KeyResult keyResult) {
        Objective objective = objectiveRepository.findById(objectiveId).orElseThrow(() -> new RuntimeException("Objective not found"));
        keyResult.setObjective(objective);
        return keyResultRepository.save(keyResult);
    }
}
