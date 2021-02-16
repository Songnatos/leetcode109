import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
    int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<n;i=i+2){
            res+=nums[i];
        }
        return res;
    }
}