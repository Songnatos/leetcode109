import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxProfit(int[] prices) {
       int min=prices[0];
       int max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }else{
                max=Math.max(prices[i]-min,max);
            }
        }
        return max;
    }
}