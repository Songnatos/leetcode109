import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        int n=A.length;
        List<Integer> res=new ArrayList<Integer>();
        for(int i=n-1;i>=0;i--){
            int sum=A[i]+K%10;
            K=K/10;
            if(sum>9){
                sum=sum-10;
                K++;
            }
            res.add(sum);
        }
        for(;K>0;K=K/10){
            res.add(K%10);
        }
        Collections.reverse(res);
    return res;

    }
}