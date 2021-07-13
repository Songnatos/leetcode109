import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        int n = 2;
        int sum = (1+n)*n/2;
        while (target >= sum) {
            if ((target - sum) % n == 0) {
                int x = (target - sum) / n;
                int[] oneRes = new int[n];
                for (int i = 0; i < n; i++) {
                    oneRes[i] = x + i + 1;
                }
                resList.add(oneRes);
            }
            n++;
            sum = (1+n)*n/2;
        }
        int[][] res = new int[resList.size()][];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(resList.size()-1-i);
        }
        return res;
    }
}
