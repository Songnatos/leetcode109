class Solution {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 1; i < coins.length+1; i++) {
            int c = coins[i-1];
            for (int j = 1; j < amount+1; j++) {
                if (j % c == 0) {
                    dp[i][j] = Math.max(dp[i-1][j-c] + dp[i][j-c], 1);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
