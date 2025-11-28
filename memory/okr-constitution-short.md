# OKR Constitution - Quick Reference

## Quick Start Formula

> **"I will [Objective] as measured by [Key Results]"**

**Example**: "I will **increase customer satisfaction** as measured by **NPS score increasing from 7 to 9**, **churn reducing from 10% to 5%**, and **publishing 15 customer case studies**."

This simple template helps create well-formed OKRs in seconds.

---

## Core Principles

### 0. The 70% Rule ⭐

**Target**: Achieving **65-70% of ambitious OKRs is EXCELLENT** (Google/Intel standard)

| Score | Meaning | Next Action |
|-------|---------|-------------|
| 0-40% | Needs attention | Reassess or add resources |
| 40-70% | **PERFECT** ✅ | Celebrate! This is the target. |
| 70-90% | Great work | Well done, aim higher next time |
| 90-100% | Possible sandbagging | Goals may be too easy |

> "OKRs should be set high: the desired target overall average score is 65%..." - Google Engineering

**Why?** Encourages ambitious goals without fear of "failure."

---

### ⚠️ CRITICAL WARNING: Never Tie OKRs to Compensation

**NEVER** link OKRs directly to:
- ❌ Performance reviews
- ❌ Bonuses
- ❌ Salary increases
- ❌ Promotions

**Why this destroys the system**:
1. **Sandbagging**: People set easy goals to guarantee 100%
2. **Risk aversion**: No one tries ambitious stretch goals
3. **Gaming**: Focus on looking good vs doing good work

> "OKRs are NOT used directly as input to performance appraisals." - Google

**Correct approach**: OKRs are ONE input among many for performance discussions.

---

### 1. Outcomes Over Outputs
- **Key Results must be OUTCOMES** (measurable results/impact), NOT outputs (tasks/deliverables)
- ❌ Bad: "Deploy new caching service"
- ✅ Good: "Reduce average API response time from 300ms to 150ms"

### 2. The "Why" Test
Keep asking "Why?" until you reach the business outcome:
- Output: "Implement new sales process" → Why? → Outcome: "Reduce lead-to-close time from 14 days to 10 days"

## OKR Structure

### Objective (The "What")
- **Qualitative**, inspiring, memorable
- Action-oriented and meaningful
- 10 words or less preferred
- Examples:
  - "Achieve first-class, reliable production environment"
  - "Become undisputed performance leader in our market"

### Key Results (The "How to Measure")
- **Quantitative**, specific, time-bound
- **SMART**: Specific, Measurable, Achievable, Relevant, Time-bound
- 2-5 KRs per Objective
- Each KR should have Min/Target/Max values
- Use **leading indicators** over lagging indicators when possible

### Classification

**By Scope:**
- `COMPANY`: Organization-wide strategic priorities (annual)
- `TEAM`: Team-level quarterly objectives
- `INDIVIDUAL`: Personal development goals

**By Purpose:**
- `COMMITTED`: Must achieve 100% (realistic but challenging)
- `ASPIRATIONAL`: "Moonshot" goals, 60-70% success expected
- `LEARNING`: Hypothesis testing, success = validated learning

## Validation Rules

### Critical Rules (Must Enforce):

1. **Weight Validation**
   ```
   Sum of all KR weights under one Objective = 100%
   ```

2. **KR Type Validation**
   - Type must be: `PERCENTAGE`, `INCREASING`, or `DECREASING`
   - For `INCREASING`: Min ≤ Target ≤ Max
   - For `DECREASING`: Min ≥ Target ≥ Max

3. **Outcome vs Output Check**
   - KR must describe a measurable result, not a task
   - KR should answer: "How do we know we achieved the Objective?"

4. **Progress Tracking**
   - Progress: 0-100%
   - Target Date: YYYY-MM-DD format
   - Current Value tracked against Min/Target/Max

## Markdown Format Template

```markdown
### OKR [N]: [Title]

*   **Hedef (Objective):** [Inspiring description of what to achieve]
*   **Kapsam:** [COMPANY/TEAM/INDIVIDUAL]
*   **Amaç:** [COMMITTED/ASPIRATIONAL/LEARNING]

*   **Anahtar Sonuçlar (Key Results):**
    1.  **KR 1 ([Label]):** [Outcome description with metric]
        *   **İzleme:**
            *   **Ağırlık:** [XX]%
            *   **İlerleme:** [0-100]%
            *   **Hedef Tarih:** YYYY-MM-DD
            *   **KR Tipi:** [PERCENTAGE/INCREASING/DECREASING]
            *   **Değerler:**
                *   **Minimum:** [Value + unit]
                *   **Hedef:** [Value + unit]
                *   **Maksimum:** [Value + unit]
```

## Common Anti-Patterns to Avoid

| Anti-Pattern | Problem | Fix |
|--------------|---------|-----|
| "To-Do List" KRs | Lists tasks/outputs | Convert to outcome metrics |
| "Set and Forget" | No weekly check-ins | Regular progress reviews |
| "Business as Usual" | No stretch/innovation | Mix committed + aspirational |
| "Too Many OKRs" | Diluted focus | 1-3 Objectives, 3-5 KRs each |
| "Tied to Salary" | Sandbagging | Decouple from compensation |

## Example: Good vs Bad

### ❌ Bad OKR (Output-focused)
**Objective:** Improve developer productivity
- KR1: Complete CI/CD pipeline setup
- KR2: Write 100 unit tests
- KR3: Deploy monitoring dashboard

### ✅ Good OKR (Outcome-focused)
**Objective:** Dramatically accelerate development velocity
- KR1: Reduce average "Lead Time for Changes" from 48h to 8h (DORA metric)
- KR2: Increase deployment frequency from weekly to daily
- KR3: Decrease "Change Failure Rate" from 15% to <5%

## AI Evaluation Checklist

When evaluating OKRs, check:
1. ✓ All KR weights sum to 100% per Objective
2. ✓ KRs are outcomes (results), not outputs (tasks)
3. ✓ Objectives are inspiring and qualitative
4. ✓ Each KR has Min/Target/Max values
5. ✓ KR Types are valid and value relationships are correct
6. ✓ Progress and dates are realistic
7. ✓ Scope and Purpose are appropriate

## Quick References

### DORA Metrics (for Engineering KRs)
- **Deployment Frequency**: How often to production
- **Lead Time for Changes**: Commit to production time
- **Change Failure Rate**: % of deploys causing failure
- **Mean Time to Restore (MTTR)**: Recovery time

### SLO/SLI (for Reliability KRs)
- **SLI**: Service Level Indicator (e.g., uptime %)
- **SLO**: Service Level Objective (e.g., 99.9% uptime)

---

**Remember**: OKRs are about **alignment** (everyone rowing same direction), **focus** (saying no to distractions), and **measurement** (data-driven progress).
