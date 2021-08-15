import java.util.*;

class Solution {
    public List< List<Integer> > threeSum(int[] nums) {
        Map<Integer, Integer> zheng = new HashMap<>();
        Map<Integer, Integer> fu = new HashMap<>();
        int zeroCount = 0;

        for (int num : nums) {
            if (num > 0) {
                zheng.put(num, zheng.containsKey(num) ? zheng.get(num)+1 : 1);
            } else if (num < 0) {
                fu.put(num, fu.containsKey(num) ? fu.get(num)+1 : 1);
            } else {
                zeroCount++;
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        if (zeroCount >= 3) {
            List<Integer> ans = Arrays.asList(0, 0, 0);
            res.add(ans);
        }
        if (zeroCount > 0) {
            for (Integer zs : zheng.keySet()) {
                if (fu.containsKey(-zs)) {
                    List<Integer> ans = Arrays.asList(0, zs, -zs);
                    res.add(ans);
                }
            }
        }
        calc(zheng, fu, res);
        calc(fu, zheng, res);

        return res;
    }

    private void calc(Map<Integer, Integer> one, Map<Integer, Integer> two, List<List<Integer>> res) {
        Integer[] set = one.keySet().toArray(new Integer[0]);
        for (int i = 0; i < set.length; i++) {
            int a = set[i];
            if (one.get(a) > 1 && two.containsKey(-(2*a))) {
                List< Integer > ans = Arrays.asList(a, a, -(2*a));
                res.add(ans);
            }
            for (int j = i+1; j < set.length; j++) {
                int b = set[j];
                if (two.containsKey(-(a+b))) {
                    List< Integer > ans = Arrays.asList(a, b, -(a + b));
                    res.add(ans);
                }
            }
        }
    }
}
