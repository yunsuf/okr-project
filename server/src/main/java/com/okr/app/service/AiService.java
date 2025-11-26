package com.okr.app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okr.app.model.Objective;
import com.okr.app.model.KeyResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AiService {

    @Value("${ai.provider:ollama}")
    private String provider;

    @Value("${ai.openrouter.key:}")
    private String openRouterKey;

    @Value("${ai.ollama.url:http://localhost:11434/api/generate}")
    private String ollamaUrl;

    @Value("${ai.openrouter.url:https://openrouter.ai/api/v1/chat/completions}")
    private String openRouterUrl;
    
    @Value("${ai.model:mistral}")
    private String model;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Load prompt template from file
    private String loadPromptTemplate(String templateName) {
        try {
            Path templatePath = Paths.get("prompts", templateName + ".md");
            if (Files.exists(templatePath)) {
                return Files.readString(templatePath);
            } else {
                // Fallback to basic prompt if file not found
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String callLlm(String prompt) {
        if ("openrouter".equalsIgnoreCase(provider)) {
            return callOpenRouter(prompt);
        } else {
            return callOllama(prompt);
        }
    }

    private String callOllama(String prompt) {
        try {
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", model);
            requestBody.put("prompt", prompt);
            requestBody.put("stream", false);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(ollamaUrl, entity, String.class);

            JsonNode root = objectMapper.readTree(response.getBody());
            return root.path("response").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling Ollama: " + e.getMessage();
        }
    }

    private String callOpenRouter(String prompt) {
        try {
            Map<String, Object> message = new HashMap<>();
            message.put("role", "user");
            message.put("content", prompt);

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", model);
            requestBody.put("messages", List.of(message));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + openRouterKey);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(openRouterUrl, entity, String.class);

            JsonNode root = objectMapper.readTree(response.getBody());
            return root.path("choices").get(0).path("message").path("content").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error calling OpenRouter: " + e.getMessage();
        }
    }

    public String evaluateOkrs(List<Objective> objectives) {
        try {
            String template = loadPromptTemplate("evaluate-okr");
            
            // Build OKR data JSON
            String okrData = objectMapper.writeValueAsString(objectives);
            
            // Combine template with data
            String fullPrompt = template + "\n\n## OKR Data\n```json\n" + okrData + "\n```";
            
            return callLlm(fullPrompt);
        } catch (Exception e) {
            e.printStackTrace();
            // Fallback to basic prompt
            return evaluateOkrsBasic(objectives);
        }
    }

    private String evaluateOkrsBasic(List<Objective> objectives) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("You are an expert OKR Coach. Evaluate these OKRs based on Constitution rules:\n");
        prompt.append("1. Weights must sum to 100% per Objective\n");
        prompt.append("2. Key Results must be OUTCOMES, not outputs\n");
        prompt.append("3. Provide score out of 100 and specific recommendations\n\n");
        
        for (Objective obj : objectives) {
            prompt.append("Objective: ").append(obj.getTitle()).append("\n");
            prompt.append("Scope: ").append(obj.getScope()).append(", Purpose: ").append(obj.getPurpose()).append("\n");
            if (obj.getKeyResults() != null) {
                for (KeyResult kr : obj.getKeyResults()) {
                    prompt.append("  KR: ").append(kr.getTitle()).append(" (Weight: ").append(kr.getWeight()).append("%)\n");
                }
            }
            prompt.append("---\n");
        }
        return callLlm(prompt.toString());
    }

    public String chatWithOkrs(List<Objective> objectives, String question) {
        try {
            String template = loadPromptTemplate("chat-okr");
            String okrData = objectMapper.writeValueAsString(objectives);
            
            String fullPrompt = template + "\n\n## OKR Data\n```json\n" + okrData + "\n```\n\n## User Question\n" + question;
            
            return callLlm(fullPrompt);
        } catch (Exception e) {
            e.printStackTrace();
            return chatWithOkrsBasic(objectives, question);
        }
    }

    private String chatWithOkrsBasic(List<Objective> objectives, String question) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("You are an OKR Assistant. Answer based on these OKRs:\n");
        for (Objective obj : objectives) {
            prompt.append("- ").append(obj.getTitle()).append(" (").append(obj.getScope()).append(")\n");
            if (obj.getKeyResults() != null) {
                for (KeyResult kr : obj.getKeyResults()) {
                    prompt.append("  * ").append(kr.getTitle()).append(" (").append(kr.getProgress()).append("% done)\n");
                }
            }
        }
        prompt.append("\nQuestion: ").append(question).append("\n");
        return callLlm(prompt.toString());
    }

    public String generateOkr(String userPrompt) {
        try {
            String template = loadPromptTemplate("generate-okr");
            String fullPrompt = template.replace("[USER_GOAL_HERE]", userPrompt);
            
            return callLlm(fullPrompt);
        } catch (Exception e) {
            e.printStackTrace();
            return generateOkrBasic(userPrompt);
        }
    }

    private String generateOkrBasic(String userPrompt) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate OKRs in this EXACT Markdown format:\n\n");
        prompt.append("### OKR 1: [Title]\n");
        prompt.append("*   **Hedef (Objective):** [Description]\n");
        prompt.append("*   **Kapsam:** TEAM\n");
        prompt.append("*   **Amaç:** COMMITTED\n");
        prompt.append("*   **Anahtar Sonuçlar (Key Results):**\n");
        prompt.append("    1.  **KR 1:** [Outcome with metric]\n");
        prompt.append("        *   **Ağırlık:** 40%\n");
        prompt.append("        *   **KR Tipi:** INCREASING\n");
        prompt.append("IMPORTANT: Weights must sum to 100%. KRs must be OUTCOMES, not tasks.\n\n");
        prompt.append("Goal: ").append(userPrompt);
        
        return callLlm(prompt.toString());
    }
}
