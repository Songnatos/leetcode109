import java.lang.reflect.Array;
        import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res=new int[k];
        for(int i=0;i<arr.length-k;i++){
            res[i]=arr[arr.length-k+i];
        }
        return res;
    }
}