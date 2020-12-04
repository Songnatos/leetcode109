import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int a : nums) {
            if (!map.containsKey(a)) {
                map.put(a, new PriorityQueue<>());
            }
            if (!map.containsKey(a-1)) {
                map.get(a).add(1);
            } else {
                map.get(a).add(map.get(a-1).poll()+1);
                if (map.get(a-1).size() == 0)
                    map.remove(a-1);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().peek() < 3)
                return false;
        }

        return true;
    }
}
