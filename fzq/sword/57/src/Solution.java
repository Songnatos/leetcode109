class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1, sum;
        while ((sum = nums[i] + nums[j]) != target) {
            if (sum < target)
                i++;
            else
                j--;
        }
        return new int[]{nums[i], nums[j]};
    }
}
