class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res != nums[i]) {
                if (count > 1) {
                    count--;
                } else if (count == 1) {
                    res = nums[i];
                }
            } else {
                count++;
            }
        }
        return res;
    }
}
