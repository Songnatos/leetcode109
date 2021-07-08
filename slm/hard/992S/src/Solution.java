class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
    return getMost(A,K)-getMost(A,K-1);
    }
    public int getMost(int[] A, int k){
        int left=0;int right=0;int res=0;
        int[] count=new int[A.length+1];
        int num=0;
        while(right<A.length){
            if (count[A[right]]==0){
                num++;
            }
            count[A[right]]++;
            right++;
            while(num>k){
                count[A[left]]--;
                if(count[A[left]]==0){
                    num--;
                }
                left++;
            }
            res+=right-left;
        }
        return  res;
    }
}