class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            int cost1 = dp[i-2] + cost[i-2];
            int cost2 = dp[i-1] + cost[i-1];
            if (cost1 > cost2) {
                dp[i] = cost2;
            } else {
                dp[i] = cost1;
            }
        }
        return dp[cost.length];
    }
}