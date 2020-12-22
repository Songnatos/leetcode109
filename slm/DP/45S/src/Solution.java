class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        res[n-1]=0;
        for(int i=n-2;i>=0;i--){
            res[i]=min(i,Math.min(i+nums[i],n-1),res)+1;
        }
        return res[0];
    }
    public int min(int start,int end,int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=end;i>start;i--){
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min==Integer.MAX_VALUE?99:min;
    }
}