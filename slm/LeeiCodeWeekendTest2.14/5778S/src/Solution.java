class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=0;int high=10001;
        while(low+1<high){
            int mid=low+(high-low)/2;
            if(cando(nums,mid,maxOperations)){
                high=mid;
            }else{
                low=mid;
            }
        }
        if (cando(nums, low, maxOperations))
            return low;

        return high;

    }
    public boolean cando(int[] nums,int penalty, int maxOperations){
        int res=0;

        for(int i:nums){
            res+=i/penalty;
            if(i%penalty==0){
                res--;
            }
            if(res>maxOperations){
                return false;
            }
        }
        return true;

    }
}