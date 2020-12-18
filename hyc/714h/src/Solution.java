class Solution {

    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp[i - 1][1] + prices[i] - fee;
            dp[i][0] = dp[i - 1][0] > temp ? dp[i - 1][0] : temp;
            int temp2 = dp[i - 1][0] - prices[i];
            dp[i][1] = dp[i - 1][1] > temp2 ? dp[i - 1][1] : temp2;
        }
        return dp[prices.length - 1][0];
    }

}
