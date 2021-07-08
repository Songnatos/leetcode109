class NumArray {
    int[] num;

    public NumArray(int[] nums) {
        num=new int[1000000];
        for(int i=0;i<nums.length;i++){
            num[i]=nums[i];
        }

    }

    public int sumRange(int i, int j) {
    int res=0;
    for(int  k=i;k<j+1;k++){
        res+=num[k];
    }
    return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */