import java.util.Arrays;

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length;
        int m=multipliers.length;
        int res=0;
        Arrays.sort(multipliers);
        int start1=0;
        int end1=n-1;
        int start2=0;
        int end2=m-1;
        int count=m;
        while(count>1){
            int max=Math.max(Math.max(nums[start1]*multipliers[start2],nums[start1]*multipliers[end2])
                    ,Math.max(nums[end1]*multipliers[start2],nums[end1]*multipliers[end2]));
            res+=max;
            if(max==nums[start1]*multipliers[start2]){
                start1++;
                start2++;
            }else if(max==nums[start1]*multipliers[end2]){
                start1++;
                end2--;
            }else if(max==nums[end1]*multipliers[start2]){
                end1--;
                start2++;
            }else {
                end1--;
                end2--;
            }
            count--;
        }
        int max=Math.max(Math.max(nums[start1]*multipliers[start2],nums[start1]*multipliers[end2])
                ,Math.max(nums[end1]*multipliers[start2],nums[end1]*multipliers[end2]));
        res+=max;
        return res;

    }
}