class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n=nums .length;
    if(n==0){
        return 0;
    }
    if(n==1){
        return 1;
    }
    int temp=0,max=0;
    for(int i=1;i<n;i++){
        if(nums[i]>nums[i-1]){
            temp++;
        }else{
            max=Math.max(temp,max);
            temp=0;
        }
    }
    return max;
    }
}