class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=n-k;
        nums=rot(nums,0,k);
        nums=rot(nums,k,n);
        nums=rot(nums,0,n);
    }
    public int[] rot(int[] nums, int start,int end) {
        for(int i=start;i<(start+end+1)/2;i++){
            int temp=nums[i];
            nums[i]=nums[end-i-1+start];
            nums[end-i-1+start]=temp;
        }
        return nums;
    }
}