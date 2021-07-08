class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int tempsum=0;
        for(int i=0;i<nums.length;i++){
            int temp=sum-nums[i];
            if(temp%2==0&&tempsum==temp/2){
                return i;
            }
            tempsum=tempsum+nums[i];
        }
        return -1;
    }
}