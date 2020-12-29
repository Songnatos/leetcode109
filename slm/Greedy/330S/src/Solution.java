class Solution {
    public int minPatches(int[] nums, int n) {
    int length=nums.length;
    int res=0;
    int index=0;
    long x=1;//防止x*2超过int限制
    while(n>=x){//只有n=x+1退出
        if(index<length&&x>=nums[index]){
            x=x+nums[index];//加大范围
            index++;
        }else{
            x=x*2;//范围乘以2
            res++;//加了该数
        }
    }
    return res;
    }
}