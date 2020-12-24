class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n];
        res[n-1]=nums[n-1];
        int max=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){//加一个滑动窗口
            for(int j=i+1;j<Math.min(n,i+k+1);j++){
                if(res[j]>max){
                    max=res[j];
                }
            }
            res[i]=max+nums[i];
        }
        return res[0];
    }
}

