import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
//        char[] chars = pattern.toCharArray();
        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(str[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), str[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(str[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
