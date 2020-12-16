class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            temp[i]=0;
        }
        for(int i=0;i<nums.length;i++){
            if(temp[nums[i]]==0){
                temp[i]=1;
            }else{
                return nums[i];
            }
        }
        return 0;
        }
}