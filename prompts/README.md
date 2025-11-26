# Prompt Templates - README

## Overview
This directory contains structured prompt templates for the OKR system's AI features. Each template follows 2025 best practices for prompt engineering, including clear role definition, structured output formats, and validation checklists.

## Template Structure

All prompts follow this pattern:
```
## Role
[Who/what the AI is]

## Context
[Background information]

## Task
[What the AI must do]

## [Rules/Guidelines]
[Constraints and requirements]

## Output Format
[Exact structure expected]

## Guardrails
[What NOT to do]

## Checklist
[Pre-response validation]
```

## Available Templates

### 1. `evaluate-okr.md`
**Purpose**: Evaluate existing OKRs against Constitution rules  
**Input**: JSON with objectives and key results  
**Output**: Structured Markdown evaluation report with scores and recommendations

**Key Features**:
- Constitution rule validation (weights, outcome vs output, KR types)
- SMART criteria assessment
- Actionable recommendations
- Per-objective analysis

### 2. `generate-okr.md`
**Purpose**: Generate new OKRs from user goals  
**Input**: Natural language goal/strategy  
**Output**: Structured Markdown OKRs in exact template format

**Key Features**:
- Outcome-focused KR generation
- Automatic weight balancing (ensures 100% sum)
- Min/Target/Max value setting
- SMART validation

### 3. `chat-okr.md`
**Purpose**: Answer questions about existing OKRs  
**Input**: User question + OKR context  
**Output**: Conversational response with actionable insights

**Key Features**:
- Context-aware responses
- Progress interpretation
- Priority recommendations
- Risk identification

## Usage in Code

### Loading Templates
```java
// In AiService.java
private String loadPromptTemplate(String templateName) throws IOException {
    Path templatePath = Paths.get("prompts", templateName + ".md");
    return Files.readString(templatePath);
}
```

### Building Prompts
```java
public String evaluateOkrs(List<Objective> objectives) {
    String template = loadPromptTemplate("evaluate-okr");
    String okrData = objectMapper.writeValueAsString(objectives);
    
    String fullPrompt = template + "\n\n## OKR Data\n```json\n" + okrData + "\n```";
    
    return callLlm(fullPrompt);
}
```

## Best Practices Applied

### From Research (2025)
1. ✅ **Role-Based Prompting**: Each template assigns a specific expert persona
2. ✅ **Clear Output Format**: Exact structure specified (Markdown/JSON)
3. ✅ **Few-Shot Examples**: Templates include input→output examples
4. ✅ **Guardrails**: Explicit "do not" instructions
5. ✅ **Validation Checklists**: Pre-response verification steps
6. ✅ **Context Provision**: Background and constraints clearly stated
7. ✅ **Structured Sections**: Markdown headings for clarity
8. ✅ **Concise Language**: Direct, unambiguous instructions
9. ✅ **Chain-of-Thought**: Step-by-step reasoning for generation
10. ✅ **Model-Agnostic**: Works with both Ollama and OpenRouter

## Customization

### Adding a New Template
1. Create `prompts/[name]-okr.md`
2. Follow the standard structure (Role → Context → Task → Output → Guardrails → Checklist)
3. Include concrete examples
4. Add validation rules
5. Update this README

### Modifying Templates
- Keep role definitions specific and expert-focused
- Always include output format section
- Maintain guardrails to prevent hallucination
- Test with both Ollama (local) and OpenRouter (API)

## Testing
Test each template with:
- Valid input (should produce correct output)
- Invalid input (should catch errors)
- Edge cases (empty data, extreme values)
- Both LLM providers (Ollama, OpenRouter)

## Version History
- v1.0 (2025-11-26): Initial templates based on 2025 best practices

## References
- [OpenAI Prompt Engineering Guide](https://platform.openai.com/docs/guides/prompt-engineering)
- [Anthropic Prompt Engineering](https://docs.anthropic.com/claude/docs/prompt-engineering)
- [LangChain Prompt Templates](https://python.langchain.com/docs/modules/model_io/prompts/)
