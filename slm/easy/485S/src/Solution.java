class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int temp=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                temp++;
            }
            else{
                max=Math.max(max,temp);
                temp=0;
            }
        }
    return max;
    }
}