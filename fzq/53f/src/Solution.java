class Solution {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int s = 0, res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = s + nums[i];
            s = Math.max(dp[i], 0);
            res = Math.max(dp[i], res);
        }

        return res;
    }

}
