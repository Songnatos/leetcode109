class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[100000];
        for (int num : nums) {
            if (++hash[num] > 1) {
                return num;
            }
        }
        return 0;
    }
}
