class Solution {
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            map[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - 'a'] != 0) {
                map[t.charAt(i) - 'a']--;
            } else {
                return t.charAt(i);
            }
        }
        return 'a';
    }
}
