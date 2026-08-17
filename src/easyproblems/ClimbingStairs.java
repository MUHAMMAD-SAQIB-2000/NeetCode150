package easyproblems;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println("Top-Down:");
        System.out.println("Test Case 1: " + climbStairsTopDown(2) + ", Expected: 2");
        System.out.println("Test Case 2: " + climbStairsTopDown(5) + ", Expected: 8");

        System.out.println("\n========================");

        System.out.println("Bottom-Up:");
        System.out.println("Test Case 1: " + climbStairsBottomUp(2) + ", Expected: 2");
        System.out.println("Test Case 2: " + climbStairsBottomUp(5) + ", Expected: 8");
    }

    // Top-Down: recursive with memoization
    public static int climbStairsTopDown(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }

    private static int helper(int n, Map<Integer, Integer> memo) {
        if (n <= 2) return n;

        if (memo.containsKey(n)) return memo.get(n);

        int result = helper(n - 1, memo) + helper(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    // Bottom-Up: iterative with a table
    public static int climbStairsBottomUp(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

}
