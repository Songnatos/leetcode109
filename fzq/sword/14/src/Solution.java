class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[Math.max(n+1, 8)];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        dp[7] = 12;
        if (n <= 7)
            return dp[n];
        for (int i = 8; i < n+1; i++) {
            dp[i] = Math.max(dp[i-2] * 2, dp[i-3] * 3);
        }

        return dp[n];
    }
}
