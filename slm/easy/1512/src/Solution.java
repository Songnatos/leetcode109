class Solution {
    public int numIdenticalPairs(int[] nums) {//可以再建一个数组记录 时间更快
        int res=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    res++;
                }
            }
        }
        return res;

    }
}