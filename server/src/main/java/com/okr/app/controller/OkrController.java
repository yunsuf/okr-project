package com.okr.app.controller;

import com.okr.app.model.KeyResult;
import com.okr.app.model.Objective;
import com.okr.app.service.OkrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/okr")
@CrossOrigin(origins = "http://localhost:5173") // Allow frontend access
public class OkrController {

    @Autowired
    private OkrService okrService;

    @GetMapping
    public List<Objective> getAllObjectives() {
        return okrService.getAllObjectives();
    }

    @GetMapping("/user/{userId}")
    public List<Objective> getObjectivesByUser(@PathVariable Long userId) {
        return okrService.getObjectivesByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public Objective createObjective(@PathVariable Long userId, @RequestBody Objective objective) {
        return okrService.createObjective(objective, userId);
    }

    @PutMapping("/{id}")
    public Objective updateObjective(@PathVariable Long id, @RequestBody Objective objective) {
        return okrService.updateObjective(id, objective);
    }

    @DeleteMapping("/{id}")
    public void deleteObjective(@PathVariable Long id) {
        okrService.deleteObjective(id);
    }

    @PostMapping("/{id}/keyresult")
    public KeyResult addKeyResult(@PathVariable Long id, @RequestBody KeyResult keyResult) {
        return okrService.addKeyResult(id, keyResult);
    }

    @Autowired
    private com.okr.app.service.AiService aiService;

    @PostMapping("/ai/evaluate")
    public String evaluateOkrs(@RequestBody List<Objective> objectives) {
        return aiService.evaluateOkrs(objectives);
    }

    @PostMapping("/ai/chat")
    public String chatWithOkrs(@RequestBody ChatRequest request) {
        return aiService.chatWithOkrs(request.getObjectives(), request.getQuestion());
    }

    @PostMapping("/ai/generate")
    public String generateOkr(@RequestBody String prompt) {
        return aiService.generateOkr(prompt);
    }

    // DTO for Chat Request
    public static class ChatRequest {
        private List<Objective> objectives;
        private String question;
        
        public List<Objective> getObjectives() { return objectives; }
        public void setObjectives(List<Objective> objectives) { this.objectives = objectives; }
        public String getQuestion() { return question; }
        public void setQuestion(String question) { this.question = question; }
    }
}
