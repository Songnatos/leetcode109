

class Solution {
    public int longestOnes(int[] A, int K) {
    int n=A.length;
    int res=0;
    int[] p=new int[n+1];
    for(int i=1;i<=n;i++){
        p[i]=p[i-1]+(1-A[i-1]);
    }
    for(int i=0;i<n;i++){
        int left=binarySearch(p,p[i+1]-K);
        res=Math.max(res,i-left+1);
    }
    return res;
    }
    public int binarySearch(int[] arr,int target){
        int low=0;int high=arr.length-1;
        while(low<high){
            int mid = (high - low) / 2 + low;
            if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}