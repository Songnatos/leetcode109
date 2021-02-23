class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
    int n=nums.length;
    int m=multipliers.length;
    int[][] dp=new int[10005][10005];
    int max=Integer.MIN_VALUE;
    dp[0][0]=0;
    for(int i=1;i<=m;i++){
        dp[i][0]=dp[i-1][0]+nums[i-1]*multipliers[i-1];
    }
    for(int i=1;i<=m;i++){
            dp[0][i]=dp[0][i-1]+nums[n-i]*multipliers[i-1];
    }
    for(int i=1;i<=m;i++){
        for(int j=1;j+i<=m;j++){
            dp[i][j]=Math.max(dp[i-1][j]+nums[i-1]*multipliers[i+j-1],dp[i][j-1]+nums[n-j]*multipliers[i+j-1]);
        }
    }
    for(int i=0;i<=m;i++){
            max=Math.max(max,dp[i][m-i]);
        }
    return max;

    }
}