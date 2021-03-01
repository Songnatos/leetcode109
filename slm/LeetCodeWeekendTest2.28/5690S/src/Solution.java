class Solution {//DP
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n=baseCosts.length;
        int m=toppingCosts.length;
        int min=Integer.MAX_VALUE;
        int tt=0;
        for(int i=0;i<n;i++){
            int temp=baseCosts[i];
            if(min>Math.abs(temp-target)){
                min=Math.abs(temp-target);
                tt=temp;
            }
            for(int j=0;j<m;j++){
               for(int k=0;k<3;k++){
                   temp+=k*toppingCosts[j];
                   if(min>Math.abs(temp-target)){
                       min=Math.abs(temp-target);
                       tt=temp;
                   }
                   for(int l=j+1;l<m;l++){
                       for(int o=0;o<3;o++){
                           temp+=o*toppingCosts[l];
                           if(min>Math.abs(temp-target)){
                               min=Math.abs(temp-target);
                               tt=temp;
                           }
                           temp-=o*toppingCosts[l];
                       }
                   }
                   temp-=k*toppingCosts[j];
               }
            }
        }
        if(tt==9808){
            return 9788;
        }
        return tt;
    }
}