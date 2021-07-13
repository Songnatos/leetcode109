class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length == 0)
            return nums;
        for (int i = 0, j  = nums.length-1; i != j; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i--] - nums[j--];
            }
        }
        return nums;
    }
}
