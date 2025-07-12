#  Greedy Algorithms

Greedy algorithms are a class of algorithms that build up a solution by choosing the option that seems the best at each step. They do **not** reconsider choices once made — making them fast and efficient in certain problems.


## Key Concepts

- **Greedy Choice Property**: A global optimum can be achieved by choosing local optimums.
- **Optimal Substructure**: The optimal solution to the problem contains optimal solutions to its subproblems.
- **Pure Greedy**: they always make the greedy choice and that alone gives the optimal solution.

## When to Use?

Greedy algorithms work best when:
- You can make a decision that **seems best locally** and it guarantees a **globally optimal solution**.
- Problems involve **optimization** (e.g. maximize profit, minimize cost, etc.)


## Time Complexity

Greedy algorithms are usually faster than Dynamic Programming due to their simpler logic and fewer computations:
- Typical time complexity: `O(n log n)` or `O(n)`


---


#  Dynamic Programming (DP)

Dynamic Programming is a powerful technique used to solve **optimization** problems by breaking them into **overlapping subproblems** and solving each only once, storing the results.
##  Key Concepts

- **Overlapping Subproblems**: Same subproblems are solved multiple times.
- **Optimal Substructure**: The optimal solution to a problem contains the optimal solutions of its subproblems.
- **Memoization**: Top-down approach (recursive + cache).
- **Tabulation**: Bottom-up approach (iterative + table).

##  Time & Space Complexity

- Memoization:  
  - Time: `O(n)` to `O(n*m)` (depends on parameters)  
  - Space: Recursion stack + memo table

- Tabulation:  
  - Time: `O(n)` to `O(n*m)`  
  - Space: Only table (can optimize to 1D sometimes)

---

# DIFFERENCE 
##  Greedy vs Dynamic Programming

| Aspect                    |  Greedy Algorithm                         |  Dynamic Programming                     |
|---------------------------|-------------------------------------------|------------------------------------------|
| **Decision Approach**     | Chooses **local optimum** at each step    | Explores **all possible decisions**      |
| **Speed**                 | Faster — usually `O(n log n)` or `O(n)`   | Slower — usually `O(n²)` or `O(n³)`      |
| **Backtracking**          | No backtracking                        |  Uses backtracking/memoization          |
| **Complexity**            | Simpler and more intuitive                | More complex but more accurate           |
| **Use Case**              | When local optimum leads to global optimum | When overlapping subproblems exist       |
| **Examples**              | Activity Selection, Fractional Knapsack   | 0/1 Knapsack, Longest Common Subsequence |

---

> Use **Greedy** when local choices lead to the global optimum  
> Use **Dynamic Programming** when you need to consider all subproblems and avoid recomputation


