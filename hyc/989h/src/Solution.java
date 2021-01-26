import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length - 1;
        List<Integer> res = new ArrayList<>();
        for (int i = len; i >= 0; i --) {
            int sum = A[i] + K % 10;
            K = K / 10;
            if (sum >= 10) {
                K ++;
                sum = sum - 10;
            }
            res.add(0, sum);
        }

        while (K > 0) {
            res.add(0, K % 10);
            K = K / 10;
        }
        return res;
    }
}