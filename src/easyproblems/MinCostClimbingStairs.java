package easyproblems;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + minCostClimbingStairs(new int[]{10, 15, 20}) + ", Expected: 15");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}) + ", Expected: 6");
    }

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[n-1], dp[n-2]);
    }

}
