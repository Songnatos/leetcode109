import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] pat = pattern.toCharArray();
        String[] str = s.split(" ");
        if (pat.length != str.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pat.length; i++) {
            if (!map.containsKey(pat[i])) {
                if (map.containsValue(str[i])) {
                    return false;
                }
                map.put(pat[i], str[i]);
            } else {
                if (!map.get(pat[i]).equals(str[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
