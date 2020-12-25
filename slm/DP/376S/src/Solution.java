class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n =nums.length;
        if (nums.length < 2) return nums.length;
        int up=1;
        int down=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up=Math.max(up,down+1);
            }
            else if(nums[i]<nums[i-1]){
                down=Math.max(down,up+1);
            }
        }
        return Math.max(up,down);
    }
}

//这个解法吊
//https://leetcode-cn.com/problems/wiggle-subsequence/solution/dong-tai-gui-hua-tan-xin-suan-fa-1xing-d-ig8l/