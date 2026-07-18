# Stack Practice Set — 15 Questions (Easy → Hard)

No solutions included — this is for you to solve. Pattern hints are given so you know *which tool* to reach for, without giving the algorithm away.

---

## EASY (1–5) — Basic stack mechanics

### 1. Valid Parentheses
**Description:** Given a string containing only `()[]{}`, determine if the brackets are balanced and correctly nested.

**Input:** `s = "{[()]}"`
**Output:** `true`

**Input:** `s = "{[(])}"`
**Output:** `false`

**Pattern hint:** Push opening brackets, pop and match on closing brackets.

---

### 2. Reverse a String Using a Stack
**Description:** Reverse a string by pushing every character onto a stack, then popping them all off.

**Input:** `s = "hello"`
**Output:** `"olleh"`

**Pattern hint:** Pure LIFO — no logic needed beyond push-all-then-pop-all.

---

### 3. Implement Stack Using Arrays
**Description:** Build a stack from scratch (no `Deque`/`Stack` class) backed by a fixed-size array. Support `push`, `pop`, `peek`, `isEmpty`, and throw on overflow/underflow.

**Input:** `push(1), push(2), pop(), peek()`
**Output:** `pop() → 2`, `peek() → 1`

**Pattern hint:** Maintain a `top` index; increment before push, check bounds before decrementing on pop.

---

### 4. Baseball Game (Score Tracking)
**Description:** Given a list of operations (`"+"`, `"D"`, `"C"`, or an integer as string), simulate a score-keeping game: `"+"` sums the last two scores, `"D"` doubles the last score, `"C"` cancels/removes the last score. Return the sum of all remaining scores.

**Input:** `ops = ["5","2","C","D","+"]`
**Output:** `30`

**Pattern hint:** The stack top(s) are literally "recent scores" — the problem is describing a stack in disguise.

---

### 5. Remove All Adjacent Duplicates in a String
**Description:** Repeatedly remove pairs of adjacent equal characters until none remain.

**Input:** `s = "abbaca"`
**Output:** `"ca"`

**Pattern hint:** Push characters; if the new char equals the stack top, pop instead of pushing.

---

## MEDIUM (6–11) — Monotonic stacks, min-stack, stack simulation

### 6. Min Stack
**Description:** Design a stack that supports `push`, `pop`, `top`, and retrieving the minimum element — all in O(1).

**Input:** `push(-2), push(0), push(-3), getMin(), pop(), top(), getMin()`
**Output:** `getMin() → -3`, `top() → 0`, `getMin() → -2`

**Pattern hint:** Keep a second stack tracking the running minimum alongside the main one.

---

### 7. Next Greater Element I
**Description:** For each element in `nums1` (a subset of `nums2`), find the next greater element to its right in `nums2`. Return `-1` if none exists.

**Input:** `nums1 = [4,1,2]`, `nums2 = [1,3,4,2]`
**Output:** `[-1,3,-1]`

**Pattern hint:** Classic monotonic decreasing stack — iterate `nums2` once, pop whenever the current element is bigger than the stack top.

---

### 8. Daily Temperatures
**Description:** Given daily temperatures, return an array where each index holds the number of days you'd have to wait for a warmer temperature.

**Input:** `temperatures = [73,74,75,71,69,72,76,73]`
**Output:** `[1,1,4,2,1,1,0,0]`

**Pattern hint:** Monotonic stack of *indices*, not values — you need the distance, not just the value.

---

### 9. Evaluate Reverse Polish Notation
**Description:** Evaluate an arithmetic expression given in Reverse Polish (postfix) Notation.

**Input:** `tokens = ["2","1","+","3","*"]`
**Output:** `9`  *(explanation: (2 + 1) * 3 = 9)*

**Pattern hint:** Numbers get pushed; operators pop two operands, compute, push the result back.

---

### 10. Asteroid Collision
**Description:** Asteroids move right (positive) or left (negative) along a line. When two collide, the smaller explodes; equal-size ones both explode. Return the state after all collisions.

**Input:** `asteroids = [5,10,-5]`
**Output:** `[5,10]`

**Input:** `asteroids = [8,-8]`
**Output:** `[]`

**Pattern hint:** Push right-movers; when a left-mover appears, resolve collisions against the stack top in a `while` loop before deciding whether to push it.

---

### 11. Online Stock Span
**Description:** Design a class that, given daily stock prices one at a time, returns the "span" — the number of consecutive previous days (including today) where the price was ≤ today's price.

**Input:** `prices = [100,80,60,70,60,75,85]` (fed one at a time)
**Output:** `spans = [1,1,1,2,1,4,6]`

**Pattern hint:** Monotonic decreasing stack storing `(price, span)` pairs — fold in spans of popped elements.

---

## HARD (12–15) — Multi-structure and advanced monotonic patterns

### 12. Largest Rectangle in Histogram
**Description:** Given heights of histogram bars (width 1 each), find the area of the largest rectangle that fits within the histogram.

**Input:** `heights = [2,1,5,6,2,3]`
**Output:** `10`

**Pattern hint:** Monotonic increasing stack of indices; when you pop, the popped bar's height times the width between the new top and current index gives a candidate area.

---

### 13. Trapping Rain Water
**Description:** Given elevation heights, compute how much water can be trapped after rain.

**Input:** `height = [0,1,0,2,1,0,1,3,2,1,2,1]`
**Output:** `6`

**Pattern hint:** Monotonic decreasing stack of indices; when a taller bar appears, pop and calculate trapped water using the bounded width and min of the two surrounding heights.

---

### 14. Maximal Rectangle
**Description:** Given a binary matrix, find the area of the largest rectangle containing only 1s.

**Input:**
```
matrix = [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
```
**Output:** `6`

**Pattern hint:** Convert each row into a histogram (like Q12) by accumulating column heights, then run "Largest Rectangle in Histogram" per row.

---

### 15. Basic Calculator (with parentheses, +, -)
**Description:** Implement a calculator to evaluate a string expression containing `+`, `-`, parentheses, and non-negative integers (no `*`/`/`).

**Input:** `s = "(1+(4+5+2)-3)+(6+8)"`
**Output:** `23`

**Pattern hint:** Use a stack to save `(result_so_far, sign)` whenever you hit `(`, and restore/combine when you hit `)`.

---

## Quick self-check table

| # | Difficulty | Core Pattern |
|---|---|---|
| 1 | Easy | Bracket matching |
| 2 | Easy | Plain LIFO |
| 3 | Easy | Stack from scratch |
| 4 | Easy | Stack simulation |
| 5 | Easy | Adjacent-duplicate removal |
| 6 | Medium | Auxiliary stack (min tracking) |
| 7 | Medium | Monotonic stack (values) |
| 8 | Medium | Monotonic stack (indices) |
| 9 | Medium | Postfix evaluation |
| 10 | Medium | Stack + simulation/collision |
| 11 | Medium | Monotonic stack + span folding |
| 12 | Hard | Monotonic stack + area calc |
| 13 | Hard | Monotonic stack + water calc |
| 14 | Hard | Stack pattern reused per row |
| 15 | Hard | Stack for nested state (sign/result) |

**Rule of thumb for spotting stack problems:** if the problem mentions "next greater/smaller," "nested/balanced," "undo the most recent," or "look back until you find something bigger/smaller than me" — it's a stack, usually monotonic.