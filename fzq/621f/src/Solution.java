import java.util.HashMap;
import java.util.Map;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> wait = new HashMap<>();
        for (char c : tasks) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
                wait.put(c, 0);
            }
        }

        int i = tasks.length, time = 0;
        while (i-- > 0) {
            char key = findMax(map, wait);
            if (key == 'a') {
                i++;
            } else {
                map.put(key, map.get(key) - 1);
                wait.put(key, n);
            }
            time++;
        }
        return time;
    }

    private char findMax(Map<Character, Integer> map, Map<Character, Integer> wait) {
        char key = 'a';
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max && wait.get(entry.getKey()) == 0) {
                key = entry.getKey();
                max = entry.getValue();
            }
            if (wait.get(entry.getKey()) > 0) {
                wait.put(entry.getKey(), wait.get(entry.getKey()) - 1);
            }
        }
        return key;
    }
}
