class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        if(n==k){
            return (double) count(nums,0,n)/k;
        }
        for(int i=0;i<=n-k;i++){
            max=Math.max(max,count(nums,i,k));
        }
        return (double)max/k;
    }
    public  int count(int[] nums,int i, int k){
        int count=0;
        for(int j=0;j<k;j++){
            count+=nums[i+j];
        }
        return count;
    }
}