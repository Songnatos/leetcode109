class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n];
        int[][] max=new int[n][n];
        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               int maxvalue=0;
               for (int k = i; k <= j; k++) if (maxvalue < arr[k]) maxvalue = arr[k];
               max[i][j] = maxvalue;
           }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<n;i++)dp[i][i]=0;
        for(int i=1;i<n;i++){//长度
            for(int j=0;j<n-i;j++){//起始点
                for(int k=j;k<j+i;k++){//中间点
                    dp[j][j+i]=Math.min(dp[j][j+i],dp[j][k]+dp[k+1][j+i]+max[j][k]*max[k+1][j+i]);
                }
            }
        }return dp[0][n-1];

    }
}