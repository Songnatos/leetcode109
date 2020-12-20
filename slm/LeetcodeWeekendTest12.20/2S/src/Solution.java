class Solution {
    public int maximumUniqueSubarray(int[] nums) {//剑指OFFER 48
        if(nums.length<=1){
            return nums.length;
        }
        int[] gap=new int[10];
        for(int i=0;i<10;i++){
            gap[i]=-1;
        }
        int start=0;
        int maxlength=-1;
        for(int i=0;i<nums.length;i++){
            if(gap[nums[i]]==-1||gap[nums[i]]<start){
                gap[nums[i]]=i;

            }
            else{
                maxlength=Math.max(count(start,i,nums),maxlength);
                start=gap[nums[i]]+1;
                gap[nums[i]]=i;
            }
        }
        maxlength=Math.max(count(start,nums.length,nums),maxlength);
        return maxlength;
    }
    public int count(int start,int end,int[] nums){
        int res=0;
        for(int i=start;i<end;i++){
            res+=nums[i];
        }
        return res;
    }
}