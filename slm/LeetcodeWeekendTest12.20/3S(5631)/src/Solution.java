class Solution {//失败了 跳跃游戏
    public int maxResult(int[] nums, int k) {
    int i=0;
    int res=nums[0];
    while(i!=nums.length-1){
        int index=minindex(i+1,Math.min(nums.length-1,i+k)+1,nums);
        res+=nums[index];
        i=index;
    }
    return res;
    }
    public int minindex(int start,int end,int[] nums){
        if(end==nums.length-1){
            return nums.length-1;
        }
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=start;i<end;i++){
            if(nums[i]>0&&nums[minindex(end,Math.min(nums.length-1,end+i-start)+1,nums)]>0)
                return i;
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
        return index;
    }
}