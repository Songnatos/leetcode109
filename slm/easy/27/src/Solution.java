class Solution {
    public int removeElement(int[] nums, int val) {
        int swapindex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                swapindex=i;
                while(i<nums.length-1&&nums[i]==val){
                    i++;
                }
                nums[swapindex]=nums[i];
                nums[i]=val;
                i=swapindex;
            }
        }
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}