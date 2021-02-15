import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        int ans = edges.length * 2;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (isTriple(i, j, k, map)) {
                        ans = Math.min(ans, map.get(i).size() + map.get(j).size() + map.get(k).size() - 6);
                    }
                }
            }
        }
        return ans == edges.length * 2 ? -1 : ans;
    }

    private boolean isTriple(int i, int j, int k, Map<Integer, Set<Integer>> map) {
        return map.get(i).contains(j) && map.get(i).contains(k) && map.get(j).contains(k);
    }
}
