class Solution {//DP思想
    public int maxProfit(int[] prices,int fee) {
        int[][] record=new int[prices.length][2];
        record[0][0]=0;
        record[0][1]=-prices[0]-fee;
        for(int i=1;i<prices.length;i++){
            record[i][0]= Math.max(record[i-1][0],record[i-1][1]+prices[i]-fee);
            record[i][1]= Math.max(record[i-1][1],record[i-1][0]-prices[i]-fee);
        }
        return record[prices.length-1][0];
    }
}