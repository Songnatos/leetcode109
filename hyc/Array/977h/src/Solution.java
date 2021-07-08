class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int index = nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (index >= 0) {
            if (-nums[left] >= nums[right]) {
                ans[index] = nums[left] * nums[left];
                left ++;
            } else {
                ans[index] =nums[right] * nums[right];
                right --;
            }
            index --;
        }
        return ans;
    }
}