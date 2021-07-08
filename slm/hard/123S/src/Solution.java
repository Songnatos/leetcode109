class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        int[][] record=new int[3][2];
       for(int i=0;i<3;i++){
           record[i][0]=0;
           record[i][1]=-prices[0];
       }
       for(int i=0;i<prices.length;i++){
           for(int j=2;j>0;j--){
               record[j-1][1]=Math.max(record[j-1][0]-prices[i],record[j-1][1]);
               record[j][0]=Math.max(record[j][0],record[j-1][1]+prices[i]);
           }
       }
       return record[2][0];


    }

}
