class Solution {
    public int search2(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int num : nums) {
            if (num == target) {
                count++;
                flag = true;
            } else if (flag) {
                break;
            }
        }
        return count;
    }

    /**
     * 反而需要更多时间，可能是二分没写好
     */
    public int search3(int[] nums, int target) {
        int count = 0, i = 0, j = nums.length-1, mid = nums.length/2;
        while (true) {
            if (nums[mid] == target) {
                while (nums[--mid] == target);
                while (nums[++mid] == target) {
                    count++;
                }
                break;
            } else if (nums[mid] < target) {
                i = mid;
            } else if (nums[mid] > target) {
                j = mid;
            }
            mid = (i+j)/2;
        }
        return count;
    }

    /**
     * leetcode 二分题解
     */
    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
