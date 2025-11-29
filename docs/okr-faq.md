# OKR Frequently Asked Questions (FAQ)

## Core Concepts

### Q: What are OKRs?
**A**: OKRs (Objectives and Key Results) are a goal-setting framework where:
- **Objective** = What you want to achieve (qualitative, inspirational)
- **Key Results** = How you measure progress (quantitative, specific metrics)

**Formula**: `I will [Objective] as measured by [Key Results]`

**Example**: "I will **increase customer satisfaction** as measured by **NPS score from 7 to 9**, **churn reduction from 10% to 5%**, and **15 customer case studies published**."

---

### Q: Are OKRs the same as KPIs or SMART goals?
**A**: No, they serve different purposes:

| Aspect | OKRs | KPIs | SMART Goals |
|--------|------|------|-------------|
| **Purpose** | Ambitious, time-bound achievements | Ongoing business health metrics | Individual task completion |
| **Timeframe** | Quarterly/Annual | Continuous | Varies |
| **Ambition** | Stretch goals (70% = excellent) | Steady performance | 100% achievable |
| **Example** | "Launch in 3 new markets" | "Monthly revenue" | "Complete onboarding by Friday" |

---

### Q: Why should we adopt OKRs?
**A**: OKRs provide:
1. **Focus**: Clarity on top priorities (1-3 objectives max)
2. **Alignment**: Everyone knows how their work supports company goals
3. **Transparency**: Goals visible across organization
4. **Measurement**: Objective progress tracking
5. **Ambition**: Encourages thinking bigger

> "The one thing OKR provides par excellence is **focus**." - Andy Grove, Intel CEO

---

## Setting OKRs

### Q: How many OKRs should we have?
**A**: LESS IS MORE.
- **Company**: 3-5 objectives max per year/quarter
- **Team**: 1-3 objectives per quarter
- **Individual**: 1-2 objectives per quarter

Each objective should have **2-5 key results** (typically 3-4).

**Why?** Too many OKRs = no focus. Everything is a priority means nothing is.

---

### Q: What makes a good Objective?
**A**: Good objectives are:
- **Inspirational**: Meaningful progress (not "Increase metric by 2%")
- **Relatable**: Language your team understands (no jargon/acronyms)
- **Timely**: Doable this quarter (if 1 year+ → it's strategy, not OKR)
- **Actionable independently**: Your team can achieve it without dependencies
- **Measurable independently**: You can verify success without other teams

**Bad Example**: "Improve system" (vague)  
**Good Example**: "Deliver rock-solid platform reliability"

---

### Q: What makes a good Key Result?
**A**: Use the magic words: **"as measured by"**

Good KRs are:
- **Quantitative**: Has a number
- **Time-bound**: Has a deadline
- **Verifiable**: Can declare it done/not done (no ambiguity)
- **Outcome-focused**: Results, NOT tasks

> "The magic words are 'as measured by.' If a Key Result isn't measurable, time-related, if I can't declare it done, then it doesn't have the kind of fidelity or integrity that it ought to." - John Doerr

**Bad Example**: "Deploy new caching service" (task, not outcome)  
**Good Example**: "Reduce API response time from 300ms to 150ms by Q3 end"

---

### Q: How long should it take to write OKRs?
**A**: **Minutes**, not hours or days.

If you know your goals, intentions, and desired progress, writing OKRs should be fast. Spending weeks is a red flag - it means unclear strategy.

**Example from 100-person company**: 
- 1 hour writing OKRs monthly
- 1 hour reading everyone's OKRs
- Total: 2 hours/month/person

---

### Q: Should OKRs cascade top-down?
**A**: **Both top-down AND bottom-up**.

**Top-down**: Company sets strategic direction  
**Bottom-up**: Teams propose how they'll contribute

**Best practice**: 
1. Leadership sets company OKRs
2. Teams draft their OKRs aligned to company
3. Refinement cycle (feedback, coordination)
4. Final approval

This fosters ownership and alignment.

---

## OKR Targets & Scoring

### Q: What score should we target?
**A**: **65-70% is PERFECT** for stretch goals.

This is the **Google standard** and industry best practice:

| Score | Meaning | Action |
|-------|---------|--------|
| 0-40% | Urgent attention needed | Reassess or provide resources |
| 40-70% | **Excellent** - Ambitious goal | Celebrate! This is the target. |
| 70-90% | Great achievement | Well done, aim higher next time |
| 90-100% | **Possible sandbagging** | Goals were too easy, be more ambitious |

> "OKRs should be set high: the desired target overall average score is 65%, meaning that a team is encouraged to set as goals about 50% more tasks than they are likely to actually accomplish." - Google Engineering

**Why 70%?** Encourages ambitious goal-setting without fear of "failure."

---

### Q: Should OKRs be tied to performance reviews or bonuses?
**A**: **ABSOLUTELY NOT.** This is critical.

❌ **Never** link OKRs directly to:
- Performance appraisals
- Bonuses
- Compensation
- Promotions

**Why?** It destroys the system:
1. **Sandbagging**: People set easy goals to guarantee 100%
2. **Risk aversion**: No one tries ambitious stretch goals
3. **Gaming**: Focus shifts to looking good vs doing good

> "OKR scores are normally made visible across Google, but they are NOT used directly as input to an individual's performance appraisal." - Google

**Instead**: OKRs are ONE input (among many) for performance discussions, not a formula.

---

## Common Challenges

### Q: How do we handle all-or-nothing capabilities?
**A**: Yes, you can have binary OKRs, but break them into sub-KRs with progress indicators.

**Example**: "Land a team on the moon" (binary)  
**Key Results**:
1. Successfully orbit team around the moon
2. Successfully orbit team around Earth
3. Prove mission control performance during crewed mission
4. Complete safety certifications

Each sub-goal has measurable progress.

---

### Q: How do we write OKRs for refactoring/technical debt?
**A**: Frame as **business outcomes**, not tasks.

❌ **Bad**: "Refactor caching layer"  
✅ **Good**: "Reduce cost of developer time per feature by 30%"

❌ **Bad**: "Write 100 tests"  
✅ **Good**: "Reduce bug fix time from 48h to 24h" OR "Lower P1 bugs from 15/month to 5/month"

**Engineering OKR Templates**:
- Improve efficiency: "Reduce lead time for changes from 48h to 8h"
- Improve quality: "Increase test coverage from 60% to 85%"
- Reduce toil: "Automate 70% of manual deployment steps"

---

### Q: What if ad-hoc requests override our OKRs?
**A**: OKRs should serve as a **defense mechanism**.

**Script**: "That's a great idea, but it's not in our Q3 OKRs. Let's discuss adding it to Q4 planning."

This prevents constant scope creep and maintains focus. Leadership should shield teams from constant

 re-prioritization.

**Exception**: Critical incidents (P0 bugs) always override OKRs.

---

### Q: Should we have individual OKRs?
**A**: **Team OKRs preferred**, individual OKRs can be toxic.

**Risk of individual OKRs**:
- Creates competition vs collaboration
- "I ignored struggling colleagues to hit MY numbers"
- Incentivizes hoarding information

**Better approach**:
- **Team OKRs**: Shared accountability
- **Personal goals**: Separate from OKRs (1:1s with manager)
- **Contribution tracking**: How individuals helped team achieve OKRs

---

## OKR vs Other Tools

### Q: How do OKRs compare to email/chat for communication?
**A**: OKRs provide **persistent, structured context** that messages don't.

| Tool | Strengths | Weaknesses |
|------|-----------|------------|
| **Email/Chat** | Real-time communication | Buried context, hard to track progress |
| **OKRs** | Always up-to-date, visible to all, roll-ups | Not for tactical daily work |

**Example**: New team member can see all OKRs instantly vs digging through 6 months of Slack history.

---

### Q: How do OKRs compare to task lists (Jira, Trello)?
**A**: Different tools for different purposes.

| Tool | Focus | Detail Level |
|------|-------|--------------|
| **OKRs** | Top 3-5 goals | High-level outcomes |
| **Task Lists** | All to-dos | Granular tasks |

**Best practice**: Link them!
- Jira epics → map to OKRs
- Daily tasks → contribute to Key Results
- Some tools (Monday, Asana, ClickUp) now integrate both

---

## OKRs & Strategy

### Q: Are OKRs the same as strategy?
**A**: **NO.** This is a critical distinction.

**Bad**: Vision → OKRs → Work  
**Good**: **Vision → Strategy → OKRs → Roadmap → Work**

**OKRs are a MODEL of your strategy**, not the strategy itself.

**Example (Tesla)**:
- **Vision**: "Accelerate sustainable transport via mass-market EVs"
- **Strategy**: Start with sports car → use money for affordable car → even more affordable
- **OKR**: "Achieve CSAT of 9+ from Roadster customers in Q1"

Without strategy, you'd skip to Model 3 and fail. Strategy explains *why* this OKR,  not another.

> "If you fail to identify and analyze the obstacles, you don't have a strategy. Instead, you have either a stretch goal, a budget, or a list of things you wish would happen." - Richard Rumelt, Good Strategy Bad Strategy

---

## Implementation

### Q: Are OKRs heavyweight or lightweight?
**A**: **Lightweight by design.**

OKRs deliberately avoid heavy process:
- Writing: Minutes
- Tracking: Simple scores (0.0 to 1.0)
- Visibility: Single source of truth

If your OKR process feels heavy, you're doing it wrong.

---

### Q: How often should we review OKRs?
**A**: **Weekly check-ins + Quarterly reviews**

**Weekly** (5-15 min):
- Progress updates
- Blockers
- Adjustments

**Quarterly** (1-2 hours):
- Score OKRs (0.0 - 1.0)
- Retrospective: What worked? What didn't?
- Set next quarter's OKRs

**Annual** (half-day):
- Company-wide strategy review
- Set annual OKRs

---

### Q: Should OKRs be transparent?
**A**: **YES. Default to visible to everyone** in the organization.

**Why?**
- Prevents duplicated efforts
- Enables collaboration
- Builds mutual understanding
- Encourages alignment

**Rare exceptions**: 
- Maximum-security projects
- Confidential M&A

Even then, share high-level objectives if possible.

> "By clearing the line of sight to everyone's objectives, OKRs save time and money." - John Doerr

---

## Pre-Work & Setup

### Q: What pre-work is needed before setting OKRs?
**A**: **9 essential steps**:

1. **Clarify mission & vision**: Why do we exist? Where are we going?
2. **Evolve strategy**: Still relevant? Adjust for market shifts?
3. **Understand stakeholder priorities**: Customers, investors, partners
4. **Set timeframes**: Quarterly or annual?
5. **Identify resources**: Budget, capacity (realistic: 3-4 productive hours/day)
6. **Align departments**: Cross-functional meetings
7. **Review past performance**: What worked? What didn't?
8. **Involve team in brainstorming**: Build ownership
9. **Establish guidelines**: What makes a good OKR?

**Time investment**: 1-2 days for leadership team.

---

### Q: How do we get leadership buy-in?
**A**: **Leadership MUST champion OKRs** or don't bother.

> "This system works provided the leadership of the company embraces it. If the CEO doesn't believe in OKRs and won't pursue them, I suggest you not try." - John Doerr

**How to get buy-in**:
1. Show examples from Google, Intel, Microsoft success
2. Start with pilot team (prove value)
3. CEO sets personal OKRs publicly
4. Celebrate early wins

If leadership won't commit → OKRs will fail.

---

## Troubleshooting

### Q: Our OKRs keep changing mid-quarter. Is that OK?
**A**: **Rarely.** Frequent changes = unclear strategy.

**When to change**:
- ✅ Major market shift (COVID-level)
- ✅ Company pivot
- ✅ Critical opportunity/threat

**When NOT to change**:
- ❌ New shiny idea
- ❌ Ad-hoc exec request
- ❌ "This is harder than we thought"

**Best practice**: Lock OKRs for the quarter. If truly needed, have formal change process (document why, get alignment).

---

### Q: We always hit 100% of our OKRs. Is that good?
**A**: **NO. You're sandbagging.** Set more ambitious goals.

100% consistently means:
- Goals too easy
- No stretch thinking
- Missing growth opportunities

**Action**: For next quarter, aim 10-20% higher.

---

### Q: We never hit more than 40%. Should we give up?
**A**: **Check two things**:

1. **Are goals realistic but ambitious?** If yes, investigate blockers
2. **Are goals fantasy?** If yes, dial back to "yoga stretch" goals

**Progressive ambition**:
- Q1: Set conservative (build confidence)
- Q2: Increase 10%
- Q3: Increase another 10%
- Q4: Stretch goals (target 70%)

This is a marathon, not a sprint.

---

## Quick Reference

**The OKR Formula**: *I will [Objective] as measured by [Key Results]*

**The 70% Rule**: Achieving 70% of ambitious OKRs = Excellent

**Never Tie to Comp**: OKRs ≠ Performance reviews or bonuses

**Strategy First**: Vision → Strategy → OKRs → Work

**Transparency**: OKRs are visible to everyone by default

**Focus**: 3-5 objectives max, 3-4 key results each

**Ownership**: Both top-down direction + bottom-up proposals

---

*For more examples, see `/examples/industry-specific/` directory.*
