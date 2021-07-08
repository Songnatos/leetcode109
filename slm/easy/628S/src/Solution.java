import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        int res=0;
        Arrays.sort(nums);
        boolean haszero=false;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                haszero=true;
            }
        }
        if(haszero)
            return Math.max(Math.max(Math.max(nums[n-1]*nums[n-2]*nums[n-3],0),nums[0]*nums[1]*nums[n-1]),nums[0]*nums[1]*nums[n-1]);
        else{
            return Math.max(Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]),nums[0]*nums[1]*nums[n-1]);
        }
    }
}