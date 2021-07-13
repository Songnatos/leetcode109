import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
    /**
     * 超时
     */
    public int lastRemaining2(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Iterator it = list.iterator();
        it.next();
        while (list.size() > 1) {
            int i = m;
            while (--i > 0) {
                if (!it.hasNext())
                    it = list.iterator();
                it.next();
            }
            it.remove();
            if (!it.hasNext())
                it = list.iterator();
            it.next();
        }
        return list.get(0);
    }

    /**
     * 数学法
     * f(n, m) = (m % n + x) % n = (m + x) % n
     * x = f(n-1, m)
     */
    public int lastRemaining(int n, int m) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i < n+1; i++) {
            dp[i] = (m + dp[i-1]) % i;
        }
        return dp[n];
    }
}
