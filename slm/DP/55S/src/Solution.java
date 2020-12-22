class Solution {
    public boolean canJump(int[] nums) {
        boolean[] res=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=false;
        }
        res[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=i;j<=Math.min(nums.length-1,i+nums[i]);j++){
                if(res[j]){
                    res[i]=true;
                }
            }
        }
        return res[0];
    }
}