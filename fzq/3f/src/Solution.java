import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                i = map.get(chars[i]);
                res = Math.max(res, map.size());
                map.clear();
            }
        }

        return Math.max(res, map.size());
    }
}
