// Java Code: Important Dynamic Programming Algorithms (up to Matrix Chain Multiplication)

import java.util.*;

public class DPAlgorithms {

    // 1. Fibonacci (Bottom-Up)
    public static int fibonacci(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // 2. 0/1 Knapsack
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    // 3. Longest Common Subsequence
    public static int lcs(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a.length()][b.length()];
    }

    // 4. Longest Increasing Subsequence
    public static int lis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        int max = 1;
        for (int x : dp) max = Math.max(max, x);
        return max;
    }

    // 5. Matrix Chain Multiplication
    public static int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j]);
                }
            }
        }
        return dp[1][n - 1];
    }

    // Test main method
    public static void main(String[] args) {
        System.out.println("Fibonacci(10): " + fibonacci(10));

        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        System.out.println("Knapsack: " + knapsack(50, wt, val, 3));

        System.out.println("LCS: " + lcs("abcde", "ace"));

        int[] lisArr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS: " + lis(lisArr));

        int[] mcmArr = {40, 20, 30, 10, 30};
        System.out.println("Matrix Chain Multiplication: " + matrixChainOrder(mcmArr));
    }
}
