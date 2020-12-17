class Solution {
    public int maxProfit(int[] prices) {
        // 阴间测试样例 空数组
        if (prices.length == 0)
            return 0;

        // 具体逻辑
        int f1 = 0, minPrice = prices[0], f2;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            f2 = f1;
            f1 = Math.max(f2, prices[i] - minPrice);
        }
        return f1;
    }
}
