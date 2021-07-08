class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max=1;
        int n=arr.length;
        int left=0;int right=0;
        while(right<n-1){
            if(left==right){
                if(arr[left]==arr[left+1]){
                    left++;
                }
                right++;

            }else{
                if(arr[right]>arr[right-1]&&arr[right]>arr[right+1]){
                    right++;
                }else if(arr[right]<arr[right-1]&&arr[right]<arr[right+1]){
                    right++;
                }else{
                    left=right;
                }
            }
            max=Math.max(max,right-left+1);
        }

        return max;

    }

}