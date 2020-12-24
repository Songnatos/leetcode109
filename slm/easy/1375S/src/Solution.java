import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int[] temp= Arrays.copyOf(nums,n);
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(temp[i]==nums[j]){
                    res[i]=j;
                    break;
                }
            }
        }
        return res;

    }
}