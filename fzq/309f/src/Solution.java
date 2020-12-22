class Solution {
    public int maxProfit(int[] prices) {
        int[][] f = new int[prices.length][3];
        f[0][0] = 0;
        f[0][1] = 0;
        f[0][2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][2] + prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][2], f[i-1][1] - prices[i]);
        }

        return 0;
    }
}
