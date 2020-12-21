class Solution {//DP思想
    public int maxProfit(int k ,int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[][] record=new int[k+1][2];
        for(int i=0;i<=k;++i) {//初始化为了干嘛
            record[i][0] = 0;
            record[i][1] = -prices[0];
        }

        for(int i=1;i<prices.length;i++){
            for(int j=k;j>0;j--){//为什么状态压缩之后要倒叙
                record[j-1][1]= Math.max(record[j-1][1],record[j-1][0]-prices[i]);//j-1是因为[k][1]的地方不用求且下一行需要用到[j-1]
                record[j][0]= Math.max(record[j][0],record[j-1][1]+prices[i]);

            }}
        return record[k][0];
    }
}