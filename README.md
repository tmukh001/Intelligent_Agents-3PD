# 🧠 Intelligent Agents: Adaptive Strategy for Repeated 3-Player Prisoner's Dilemma

A strategic Java implementation of an **adaptive, game-theoretic agent** designed for the **three-player repeated Prisoner’s Dilemma**. Developed as part of the *SC4003: Intelligent Agents* course at NTU Singapore, this project showcases dynamic behavior modeling, retaliation logic, and robust cooperation under uncertainty.

---

## 🧩 Problem Overview

The challenge involves designing an agent that can:

- **Maximize long-term rewards** in a 3-player iterated game  
- **Balance cooperation and defense** based on opponent behavior  
- Handle opponents with fixed, random, or reactive strategies  

This extended variant of the Prisoner's Dilemma introduces new layers of complexity through **partial collusion**, **noise**, and **non-deterministic opponent types**.

---

## 💡 What This Project Demonstrates

- Design and tuning of a hybrid strategy:  
  - **Early Cooperation** to build trust  
  - **Sliding Window Defection Monitoring**  
  - **Grim Trigger-style permanent punishment**  
  - **Tit-for-Tat retaliation for short-term defense**

- Empirical evaluation against 6 diverse baseline agents:  
  - Nice, Nasty, Random, Tolerant, Freaky, and T4T Players  

- Comparative analysis of two alternative agent designs:  
  - A more aggressive variant and a more cautious one

---

## 📊 Key Results

| Metric                        | Result                              |
|------------------------------|--------------------------------------|
| Avg. Rank (10 runs)          | Top 3 in all tournaments             |
| #1 Ranking                   | 7 out of 10 tournaments              |
| Avg. Score Range             | 160.70 – 180.11                      |
| Stability vs. Defectors      | High resilience, consistent payoff   |
| Trust with Cooperative Agents| Stable long-term cooperation         |

---

## 🔍 Why It Matters

This project highlights my ability to:

- Build **adaptive agents** in multi-agent, strategic environments  
- Apply **game-theoretic principles** and behavioral modeling  
- Translate decision hierarchies into clean, modular Java code  
- Evaluate and benchmark AI agents in simulated tournaments  
- Communicate both **implementation logic** and **performance insights** through structured experimentation  

It reflects my interest in **multi-agent systems**, **strategic AI**, and **robust decision-making under interactional uncertainty**.

---

## 📁 Key Files

- `ThreePrisonersDilemma.java` — Tournament runner (provided framework)  
- `mukherjee_tathagato_Player.java` — Final implemented strategy  
- `Player 2.java` — Aggressive variant  
- `Player 3.java` — Conservative variant  
- `mukherjee_tathagato_Player.pdf` — Full technical report (design, rationale, results)

---

## 🛠️ Technologies Used

- Java  
- Simulation-based testing  
- Heuristic decision logic

To compile and run:
```bash
javac ThreePrisonersDilemma.java
java ThreePrisonersDilemma
```

---

## 👨‍💻 Author

**Tathagato Mukherjee**  
BSc (Hons), Data Science & AI, NTU Singapore
